package com.codingPractice;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MazeII {
    public class Node {
        int x;
        int y;
        int distance;
        Node (int i, int j, int d) {
            x = i;
            y = j;
            distance = d;
        }
    }

    public int shortestDistance(int[][] board, int[] start, int[] end) {
        int[][] visited = new int[board.length][board[0].length];
        if (start[0] == end[0] && start[1] == end[1]) return 0;

        for (int[] v : visited) {
            Arrays.fill(v, Integer.MAX_VALUE);
        }

        visited[start[0]][start[1]] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        pq.offer(new Node(start[0], start[1], visited[start[0]][start[1]]));

        int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (curr.x == end[0] && curr.y == end[1]) return curr.distance;
            for (int[] d : direction) {
                int nx = curr.x;
                int ny = curr.y;
                while(nx + d[0] >= 0 && nx + d[0] < board.length && ny + d[1] >= 0 && ny + d[1] < board[0].length && board[nx + d[0]][ny + d[1]] != 1) {
                    nx += d[0];
                    ny += d[1];
                }
                int distance = curr.distance + Math.abs(nx - curr.x) + Math.abs(ny - curr.y);
                if (distance < visited[nx][ny]) {
                    visited[nx][ny] = distance;
                    pq.offer(new Node(nx, ny, distance));
                }
            }
        }
        return -1;
    }


}
