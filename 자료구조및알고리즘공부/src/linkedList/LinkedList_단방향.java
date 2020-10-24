package linkedList;

public class LinkedList_단방향 {

	public static void main(String[] args) {

		LinkedList linkedList = new LinkedList();
		linkedList.append(3);
		linkedList.append(5);
		linkedList.append(2);
		linkedList.append(2);
		linkedList.append(1);
		linkedList.append(2);
		linkedList.append(5);
		
		linkedList.retrieve();
		System.out.println();

	}

}

//Node 클래스로 정의 시 헤더인 첫 노드를 지우게 되면 해당 LinkedList로 가는 포인터가 없어질 뿐만아니라
//참조하는 다른 곳에서도 오류가 발생한다.
//따라서 LinkedList 생성시 생성자로 데이터가 없는 노드릉 만들어주면서 헤더를 참조용으로만 만든다
class LinkedList {

	Node header;

	public LinkedList() {
		header = new Node();
	}

	static class Node {
		// 리스트 안에 담겨있는 데이터
		int data;
		// 다음 노드로 가는 포인터
		Node next = null;
	}

	// 다음 연결 노드 생성
	void append(int d) {
		// 노드 end 생성 => 노드 생성시 생성된 노드가 마지막 노드 = end
		Node end = new Node();
		// 스태틱 클래스이므로 직접 변수 할당
		end.data = d;
		// 마지막 노드를 찾기위해 제일 처음 노드를 포인터로 가르킨다.
		Node n = header;

		// n.next가 null이 아닐때 까지 돈다. => 다음 노드가 null이면 빠져나옴
		while (n.next != null) {
			// n에 n.next를 주며 찾아간다.
			n = n.next;
		}
		// while로 돈 n.next가 널일때 빠져나왔으므로 n.next는 마지막 노드임
		// 따라서 n.next에 end
		n.next = end;
	}

	void delete(int d) {
		// while문을 돌리기 위해 처음 노드를 포인터로 생성
		Node n = header;
		// 돌기
		while (n.next != null) {
			// 다음 노드의 데이터가 삭제할 데이터 일때
			if (n.next.data == d) {
				// 그 다음노드를 다음다음노드로 교체한다 => 다음노드는 삭제된다는 뜻 ex) ㅁ -> ㅇ -> ㄴ => ㅁ -> ㄴ
				n.next = n.next.next;
			} else {
				// 아니면 n.next를 주며 계속 돌기
				n = n.next;
			}
		}
	}

	void retrieve() {
		Node n = header.next;
		while (n.next != null) {
			System.out.print(n.data + "=>");
			n = n.next;
		}
		System.out.print(n.data);
	}
	
	//1. LinkedList에서 중복 값을 제거 하시오
	void removeDups() {
		Node n = header;
		while (n.next != null) {
			// 러너 => 항상 n의 위치에서 부터 탐색 가변적이여야함
			Node r = n;
			while (r.next != null) {
				// n.next.data == r.next.data 를 비교하는 이유
				// => r.next 가 null이 아닐때 까지 비교하기 때문에 마지막 노드에는 가지 않음
				// => 따라서 마지막 노드도 비교 해주기 위해서 next를 비교
				if (n.data == r.next.data) {
					//delete 해주는 것이 아닌 다음 주소로 변경 해줌
//					delete(r.next.data);
					r.next = r.next.next;
				} else {
					r = r.next;
				}
			}
			n = n.next;
		}
	}
	
	//2. LinkedList에서 끝에서 k번째 노드를 찾아라
	
	Node getFirst() {
		Node first = header.next;
		return first;
	}
	
	class Reference {
		private int count;
	}
	
	Node kthToLast(Node n, int k, Reference r) {
		
		if(n == null) {
			return null;
		}
		
		//kthToLast(n.next, k) 에서 n.next를 반복 호출 할때마다 안쪽까지 들어감
		//끝까지 가서 null이 나오면 0을 반환하면서 빠져나옴 그 후 빠져 나올때 마다 1을 반환하면서 나옴 => 그게 카운트
		//=>+1씩 더해지면서 반환되기 때문에 나오면서 count == k 조건이 참인게 있으면 출력하고 끝까지 반환
		Node found = kthToLast(n.next, k, r);
		r.count++;
		if (r.count == k ) {
			return n;
		}
		return found;
	}
	
	//3.x값을 기준으로 왼쪽은 작은 값 오른쪽은 값으로 나누기
	

}
