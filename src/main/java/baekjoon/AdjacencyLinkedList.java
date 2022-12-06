package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author : iyeong-gyo
 * @package : baekjoon
 * @since : 2022/12/07
 */
public class AdjacencyLinkedList {

  private static ArrayList<LinkedList> arrayList = new ArrayList<LinkedList>();
  private static int visited[] = new int[5];

  public static void main(String[] args) {
    LinkedList<Integer> integers0 = new LinkedList<>();
    integers0.add(1);
    integers0.add(2);
    integers0.add(3);
    arrayList.add(integers0);
    LinkedList<Integer> integers1 = new LinkedList<>();
    integers1.add(0);
    integers1.add(2);
    arrayList.add(integers1);
    LinkedList<Integer> integers2 = new LinkedList<>();
    integers2.add(0);
    integers2.add(1);
    arrayList.add(integers2);
    LinkedList<Integer> integers3 = new LinkedList<>();
    integers3.add(0);
    integers3.add(4);
    arrayList.add(integers3);
    LinkedList<Integer> integers4 = new LinkedList<>();
    integers4.add(3);
    arrayList.add(integers4);

    for (int i = 0; i < arrayList.size(); i++) {
      travers(i);
    }
  }

  private static void travers(Integer i) {
    if(visited[i] == 1) return;
    System.out.println(i);
    visited[i] = 1;

    LinkedList<Integer> linkedList = arrayList.get(i);
    for (int j = 0; j < linkedList.size(); j++) {
      if(visited[j] == 1) continue;
      travers(j);
    }
  }
}
