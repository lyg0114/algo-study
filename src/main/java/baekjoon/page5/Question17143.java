package baekjoon.page5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.page5
 * @url : https://www.acmicpc.net/problem/17143
 * @since : 19.04.24
 */
public class Question17143 {
  public static void main(String[] args) {
    Solution solution = new SolutionImplV2();
    try {
      solution.doMain();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  static class SolutionImplV3 implements Solution {
    static class Shark {
      int speed, direction, size;
    }

    static int R, C, M;
    static int answerSumOfSize = 0;
    static Shark[][] sharks;

    @Override
    public void doMain() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;

      // 격자판의 크기 R, C, 상어의 수 M
      st = new StringTokenizer(br.readLine());
      R = Integer.parseInt(st.nextToken());
      C = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      sharks = new Shark[R][C];

      // M 개의 줄에 상어의 정보
      for (int i = 0; i < M; i++) {
        st = new StringTokenizer(br.readLine());
        Shark shark = new Shark();
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        shark.speed = Integer.parseInt(st.nextToken());
        shark.direction = Integer.parseInt(st.nextToken());
        shark.size = Integer.parseInt(st.nextToken());
        sharks[r - 1][c - 1] = shark;
      }

      solution();
      System.out.println(answerSumOfSize);
    }

    // 낚시왕이 오른쪽으로 한칸 이동하는건 반복문의 index 로 표현
    // 현재 상어의 위치 중 제일 가까운 상어를 잡고 상어 이동 반복
    private static void solution() {
      for (int i = 0; i < C; i++) {
        fishing(i);
        moveAllSharks();
      }
    }

    // 현재 위치에서 가장 가까이에 있는 상어를 잡는다.
    private static void fishing(int col) {
      for (int i = 0; i < R; i++) {
        if (sharks[i][col] != null) {
          answerSumOfSize += sharks[i][col].size;
          sharks[i][col] = null;
          return;
        }
      }
    }

    private static void moveAllSharks() {
      Shark[][] nextSharks = new Shark[R][C];
      for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
          moveShark(nextSharks, i, j);
        }
      }

      // 이동 완료한 배열로 덮어 씌우기
      for (int i = 0; i < R; i++) {
        sharks[i] = Arrays.copyOf(nextSharks[i], C);
      }
    }

    private static void moveShark(Shark[][] nextSharks, int i, int j) {
      Shark shark = sharks[i][j];
      if (shark == null) {
        return;
      }

      // direction 1인 경우는 위, 2인 경우는 아래, 3인 경우는 오른쪽, 4인 경우는 왼쪽
      // 위아래는 R, 좌우는 C 가 X 라고 할 때 (X - 1) * 2 만큼 이동하면 동일한 위치, 방향으로 돌아온다.
      // 그러므로 상어의 속도에서 (X - 1) * 2 을 나눈 나머지만큼만 이동하면 된다.
      // 총 이동해야 할 거리 = shark.speed % ((X - 1) * 2)
      int X = shark.direction < 3 ? R : C;
      int moveDistance = shark.speed % ((X - 1) * 2);
      int row = i;
      int col = j;

      // 움직이는 거리를 구한 후에는 직접 이동시킴
      // (최종 위치를 구했을 때 방향까지 계산하기 귀찮아서.. 직접 이동)
      for (int k = 0; k < moveDistance; k++) {
        if (shark.direction == 1) {
          row--;
          if (row < 0) {
            shark.direction = 2;
            row = 1;
          }
        } else if (shark.direction == 2) {
          row++;
          if (row > R - 1) {
            shark.direction = 1;
            row = R - 2;
          }
        } else if (shark.direction == 3) {
          col++;
          if (col > C - 1) {
            shark.direction = 4;
            col = C - 2;
          }
        } else {
          col--;
          if (col < 0) {
            shark.direction = 3;
            col = 1;
          }
        }
      }

      // 만약 이미 상어가 있으면 크기를 비교해서 사이즈 큰 놈을 남긴다
      if (nextSharks[row][col] != null && nextSharks[row][col].size > shark.size) {
        return;
      }
      nextSharks[row][col] = shark;
    }
  }

  static class SolutionImplV2 implements Solution {
    public static int R, C, M;
    public static Shark[][] map;
    public static int answer = 0;
    public static int dx[] = {-1, 0, 1, 0}; //상 좌 하 우 순
    public static int dy[] = {0, -1, 0, 1};


    @Override
    public void doMain() throws IOException {
      //입력 받기
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");

      R = Integer.parseInt(st.nextToken()); // 행의 수
      C = Integer.parseInt(st.nextToken()); // 열의 수
      M = Integer.parseInt(st.nextToken()); // 상어의 수

      // 상어 낚시 격자판 만들고, 각 위치에 상어 클래스로 만든 인스턴스 저장
      map = new Shark[R][C];
      for(int i = 0; i < M; i++) {
        st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken()); // 행 위치
        int c = Integer.parseInt(st.nextToken()); // 열 위치
        int s = Integer.parseInt(st.nextToken()); // 속력
        int d = Integer.parseInt(st.nextToken()); // 이동 방향
        int z = Integer.parseInt(st.nextToken()); // 크기

        // 방향 쉽게 바꾸기위해 입력받은 상하좌우(1 2 3 4) -> 상좌하우(0 1 2 3)로 변경
        if(d == 1)
          d = 0;
        else if(d == 4)
          d = 1;

        map[r-1][c-1] = new Shark(r-1, c-1, s, d, z); // 격자판에 상어 저장
      }


      for(int col = 0; col < C; col++) { // 열의 끝까지 반복
        // 1. 낚시왕 이동
        for(int row = 0; row < R; row++) {
          if(map[row][col] != null) {
            answer += map[row][col].z; // 2. 가장 가까운 상어 크기 정답 변수에 저장
            map[row][col] = null; // map에서 상어 없애기
            break;
          }
        }

        // 3. 상어 이동
        Queue<Shark> queue = new LinkedList<>();
        for(int i = 0; i < R; i++) {
          for(int j = 0; j < C; j++) {
            if(map[i][j] != null) { // 현재 map에 있는 상어들 큐에 추가
              queue.add(new Shark(i, j, map[i][j].s, map[i][j].d, map[i][j].z));
            }
          }
        }

        map = new Shark[R][C]; // 새로운 낚시판 만들기위해 배열 초기화

        // 모든 상어 한마리씩 꺼내서 이동
        while(!queue.isEmpty()) {
          Shark sm = queue.poll();

          // 속력만큼 상어 이동 시키기
          int speed = sm.s; // 시간초과로 최소한의 이동을 위해 나머지 연산
          if(sm.d == 0 || sm.d == 2) //상 하
            speed %= (R -1) * 2;
          else if(sm.d == 1 || sm.d == 3) //좌 우
            speed %= (C -1) * 2;

          for(int s = 0; s < speed; s++) {
            // 현재 r, c에 방향에 맞게 1칸씩 추가하며 위치 이동
            int newR = sm.r + dx[sm.d];
            int newC = sm.c + dy[sm.d];

            // 이동할 새로운 위치가 범위를 벗어나 벽에 부딪히면
            if(newR < 0 || newR >= R || newC < 0 || newC >= C) {
              sm.r -= dx[sm.d]; // 다시 값 돌려주고
              sm.c -= dy[sm.d];
              sm.d = (sm.d + 2) % 4; // 방향 반대로
              continue;
            }

            // 위치 벗어나지 않을때는 새로운 위치로 이동
            sm.r = newR;
            sm.c = newC;
          }

          // 4. 새로운 위치가 빈 공간인지 이미 상어가 있는지 확인
          if(map[sm.r][sm.c] != null) { // 이미 상어가 있다면 두 상어 크기 비교
            if(map[sm.r][sm.c].z < sm.z) { // 기존 상어보다 현재 상어가 크다면
              map[sm.r][sm.c] = new Shark(sm.r, sm.c, sm.s, sm.d, sm.z); // 현재 상어 넣어줌
            }
          } else { // 없다면 현재 상어 바로 넣어줌
            map[sm.r][sm.c] = new Shark(sm.r, sm.c, sm.s, sm.d, sm.z);
          }
        }
      } // 이동 for문 끝

      System.out.println(answer);

    }

    //상어 정보를 저장할 상어 클래스
    static  class Shark {
      int r;
      int c;
      int s;
      int d;
      int z;

      Shark(int r, int c, int s, int d, int z) {
        this.r = r;
        this.c = c;
        this.s = s;
        this.d = d;
        this.z = z;
      }
    }
  }


  // ############################################################################################
  // (r,c) -> 상어의 위치
  // s -> 속력
  // d -> 이동방향 (1 : 위, 2 : 아래, 3 : 오른쪽, 4 : 왼쪽)
  // z -> 크기
  static class SolutionImplV1 implements Solution {
    static class Cell {
      List<Shark> sharks;
      public Cell(List<Shark> shark) {
        this.sharks = shark;
      }
    }

    static class Shark {
      int speed, dir, size, status;
      public Shark(int speed, int dir, int size) {
        this.speed = speed;
        this.dir = dir;
        this.size = size;
        this.status = -1;
      }

      public int getBigSharkSize() {
        return size;
      }

      @Override
      public String toString() {
        return "{" +
            "s=" + speed +
            ", d=" + dir +
            ", big=" + size +
            ", live=" + status +
            '}';
      }
    }

    int R,C,M;
    int r,c,s,d,z;
    int res;
    Cell [][] board;
    int dx[] = {-1, 1, 0, 0};
    int dy[] = {-0, 0, 1, -1};

    @Override
    public void doMain() {
      Scanner sc = new Scanner(System.in);
      R = sc.nextInt();
      C = sc.nextInt();
      M = sc.nextInt();
      board = new Cell[R][C]; // 해당 위치에 상어 존재 : 1 , 상어 존재x : 0
      for (int i = 0; i < M; i++) {
        r = sc.nextInt();
        c = sc.nextInt();
        s = sc.nextInt();
        d = sc.nextInt();
        z = sc.nextInt();
        board[r - 1][c - 1] = new Cell(new ArrayList<>(List.of(new Shark(s, d - 1, z))));
      }

      // 낙시왕의 낙시 로직
      printBoard(board);
      for (int j = 0; j < C; j++) {
        for (int i = 0; i < R; i++) {
          if (board[i][j] != null && board[i][j].sharks != null && !board[i][j].sharks.isEmpty()) {
            res += board[i][j].sharks.get(0).getBigSharkSize();
            board[i][j].sharks = null; // 잡은 상어는 board에서 제거.
            printBoard(board);
            break;
          }
          printBoard(board);
        }

        // 상어 이동 로직
        // 모든 상어 정보를 바탕으로 상어 이동
        for (int k = 0; k < R; k++) {
          for (int l = 0; l < C; l++) {
            if (board[k][l] != null && board[k][l].sharks != null && !board[k][l].sharks.isEmpty()) {
              Shark shark = board[k][l].sharks.get(0);
              if (shark.status == j) { break; }
              board[k][l].sharks = null; // 해당 위치에는 상어가 이동했으므로

              // 방향에 따른 이동 로직
              int dir = shark.dir;
              int x = k, y = l;
              for (int i = 0; i < shark.speed; i++) {
                x = x + dx[dir];
                y = y + dy[dir];
                if ((dir == 2 || dir == 3) && (y == -1 || y == C)) {
                  dir = switchingDir(dir);
                  x = x + dx[dir];
                  y = y + dy[dir];
                } else if ((dir == 0 || dir == 1) && (x == -1 || x == R)) {
                  dir = switchingDir(dir);
                  x = x + dx[dir];
                  y = y + dy[dir];
                }
              }
              shark.dir = dir; // 상어의 이동 완료후 변경된 방향정보 업데이트

              // 한번 이동했던 녀석은 건너 뛴다 중복으로 이동하지 않도록처리.
              // 이동한 곳에 다른 상어가 있을경우 작은상어는 큰상어에게 먹힘 (큰 상어 정보만 남김)
              if (board[x][y] != null && board[x][y].sharks != null && !board[x][y].sharks.isEmpty()) {
                board[x][y].sharks.add(shark);
                Shark bigShark = null;
                int size = 0;
                for (Shark curShark : board[x][y].sharks) {
                  if (size < curShark.size) {
                    size = curShark.size;
                    bigShark = curShark;
                  }
                }
                bigShark.status = j;
                board[x][y].sharks = new ArrayList<>(List.of(bigShark));
              } else {
                shark.status = j;
                board[x][y] = new Cell(new ArrayList<>(List.of(shark)));
              }
            }
          }
        }
      }

      System.out.println(res);
    }

    // 현재 상어들의 상황을 디버깅 하기 위한 메소드
    private void printBoard(Cell[][] board) {
      for (int x = 0; x < board.length; x++) {
        for (int y = 0; y < board[x].length; y++) {
          String sharkStr = "[x]                       ";
          if (board[x][y] != null && board[x][y].sharks != null) {
            sharkStr = board[x][y].sharks.get(0).toString();
          }
          System.out.print("[" + x + ", " + y + "] : " + sharkStr + " ");
        }
        System.out.println();
      }
      System.out.println();
    }

    // board의 경계에 도달했을경우 방향 전환 메소드
    private int switchingDir(int dir) {
      if(dir == 0) return 1;
      else if(dir == 1) return 0;
      else if(dir == 2) return 3;
      else if(dir == 3) return 2;
      else return -1;
    }
  }

  interface Solution {
    void doMain() throws IOException;
  }
}
