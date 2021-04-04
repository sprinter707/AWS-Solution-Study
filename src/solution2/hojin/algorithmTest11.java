package algorithm;

import java.util.Arrays;
import java.util.PriorityQueue;

public class algorithmTest11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = solution();
	}
	//더 맵게 - 힙
	public static int solution() {
		int[] scoville = { 1, 2, 3, 4, 9, 10, 12, 13 };
		int K = 7;
		int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue();

        for (int aScoville : scoville) {
            heap.offer(aScoville);
        }

        while (heap.peek() <= K) {
            if (heap.size() == 1) {
                return -1;
            }
            int a = heap.poll();
            int b = heap.poll();


            int result = a + (b * 2);

            heap.offer(result);
            answer ++;
        }
        return answer;
//		int tryNum = 0;
//        boolean criteria = false;
//		while (true) {
//			tryNum++;
//			for (int i = scoville.length / 2 - 1; i >= 0; i--) {
//				makeHeap(scoville, scoville.length, i);
//			}
//
//			for (int i = scoville.length - 1; i > 0; i--) {
//				swap(scoville, i, 0);
//				makeHeap(scoville, i - 1, 0);
//			}
//            if(scoville.length < 2) {
//				criteria = true;
//				break;
//			}
//            if(scoville.length > 2){
//                if (Math.min(scoville[1], scoville[2]) * 2 + scoville[0] >= K) {
//				scoville[0] = Math.min(scoville[1], scoville[2]) * 2 + scoville[0];
//				scoville = Arrays.stream(scoville).limit(scoville.length-1).toArray();
//				break;
//                } else {
//                    scoville[0] = Math.min(scoville[1], scoville[2]) * 2 + scoville[0];
//                    scoville = Arrays.stream(scoville).limit(scoville.length-1).toArray();
//                }
//            } else {
//                if (scoville[1] * 2 + scoville[0] >= K) {
//				scoville[0] = scoville[1]* 2 + scoville[0];
//				scoville = Arrays.stream(scoville).limit(scoville.length-1).toArray();
//				break;
//                } else {
//                    scoville[0] = scoville[1] * 2 + scoville[0];
//                    scoville = Arrays.stream(scoville).limit(scoville.length-1).toArray();
//                }
//            }
//			
//		}
//		System.out.println(tryNum);
//        if(criteria == true){
//            return -1;
//        }
//        return tryNum;

	}

//	public static void makeHeap(int[] target, int size, int targetNode) {
//
//		int parentNode = targetNode;
//		int childNode1 = targetNode * 2 + 1;
//		int childNode2 = targetNode * 2 + 2;
//
//		if (childNode1 < size && target[parentNode] < target[childNode1]) {
//			parentNode = childNode1;
//		}
//
//		if (childNode2 < size && target[parentNode] < target[childNode2]) {
//			parentNode = childNode2;
//		}
//
//		if (parentNode != targetNode) {
//			swap(target, targetNode, parentNode);
//			makeHeap(target, size, parentNode);
//		}
//
//	}
//
//	public static void swap(int[] tempArr, int a, int b) {
//		int tempInteger = tempArr[a];
//		tempArr[a] = tempArr[b];
//		tempArr[b] = tempInteger;
//	}

}
