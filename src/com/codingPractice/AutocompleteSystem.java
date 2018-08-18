package com.codingPractice;

import java.util.*;

class AutocompleteSystem {
    class TrieNode {
        public Map<Character, TrieNode> children;
        public Map<String, Integer> counts;
        public TrieNode() {
            children = new HashMap<>();
            counts = new HashMap<>();
        }
    }

    private TrieNode _root;
    private StringBuilder _prefix;

    public AutocompleteSystem(String[] sentences, int[] times) {
        _root = new TrieNode();
        _prefix = new StringBuilder();
        for (int i = 0; i < sentences.length; i++) {
            addSentence(sentences[i], times[i]);
        }
    }

    private void addSentence(String sentence, int times) {
        TrieNode current = _root;
        for (char c : sentence.toCharArray()) {
            if (!current.children.containsKey(c)) {
                current.children.put(c, new TrieNode());
            }
            current = current.children.get(c);
            current.counts.put(sentence, times);
        }
    }

    public List<String> input(char c) {
        if (c == '#') {
            addSentence(_prefix.toString(), 1);
            _prefix.setLength(0);
            return new ArrayList<String>();
        }
        _prefix.append(c);
        TrieNode current = _root;
        for (char runner : _prefix.toString().toCharArray()) {
            if (!current.children.containsKey(runner)) {
                return new ArrayList<String>();
            }
            current = current.children.get(runner);
        }

        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((a, b) -> a.getValue().compareTo(b.getValue()) == 0 ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
        queue.addAll(current.counts.entrySet());

        List<String> result = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Map.Entry<String, Integer> entry = queue.poll();
            if (entry != null) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}