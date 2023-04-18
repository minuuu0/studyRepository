package algorithm.syu.linkedlist;

// 데이터의 공간마다 다음 데이터의 주소를 가지고 있다.
class ListNode{
    private String data; // 데이터 저장 변수
    public ListNode link; // 다른 노드를 참조할 링크 노드

    public ListNode(){  // 생성자
        this.data = null;
        this.link = null;
    }
    public ListNode(String data){
        this.data = data;
        this.link = null;
    }
    public ListNode(String data, ListNode link){
        this.data = data;
        this.link = link;
    }
    public String getData(){
        return this.data;
    }

}
public class LinkedList {
    private ListNode head; // head

    // 생성자
    public LinkedList(){
        head = null; // 연결리스트의 시작점
    }

    // 노드 중간 삽입
    public void insertNode(ListNode preNode, String data){ // 이전의 노드와 데이터를 파라미터로 받는다
        ListNode newNode = new ListNode(data); // 데이터 삽입한 노드 생성

        // prenode.link = 프리노드의 다음 노드이므로,
        // newNode.link = Prenode.link가 새로운 노드의 링크가 prenode의 다음 노드를 참조하도록 함.
        newNode.link = preNode.link;

        // preNode는 자신 링크를 가리킴
        preNode.link = newNode;
    }

    // 노드 마지막 삽입
    public void insertNode(String data){ // 오버로딩
        ListNode newNode = new ListNode(data);
        if(head == null){ // 헤드가 널인 경우 새로운 노드 참조 = 아무 노드가 없을 때
            this.head = newNode;
        }else{ // 헤드 노드가 있다면
            // head노드가 null이 아닌 경우 temp노드가 head를 참조
            // temp노드는 마지막 노드를 참조하기 위해 사용
            ListNode tempNode = head;

            // temp노드의 link가 널이 아닐 때까지 반복
            // temp 노드는 다음 노드의 링크를 참조하므로 while문을 모두 실행하면 temp노드는 가장 마지막 노드를 참조한다.
            while (tempNode.link != null){
                tempNode = tempNode.link; // 마지막 노드 할당
            }
            tempNode.link = newNode; // 기존의 마지막 노드가 새로 들어온 데이터를 가리킨다.

        }
    }

    // 중간 Node 삭제
    public void deleteNode(String data){ // 1 2 3 4 5
        ListNode preNode = head; // preNode는 head 할당
        ListNode tempNode = head.link; // temp노드는 헤드 이후의 노드를 가리킴

        if(data.equals(preNode.getData())){
            // 첫번째 노드와 일치하는 경우
            head = preNode.link; // head는 삭제원소 다음 데이터가 된다
            preNode.link = null; // 삭제 원소의 link의 연결을 끊는다.
        }else{ // 첫원소가 아닌 경우
            while (tempNode != null){ // tempNode가 널 일때까지 반복
                if(data.equals(tempNode.getData())){ // 데이터가 같은 노드 발견 시
                    if(tempNode.link == null){ // temp노드가 마지막 노드인 경우
                        preNode.link = null;
                    }else{ // temp노드가 마지막이 아닌 경우
                        preNode.link = tempNode.link;
                        tempNode.link = null;
                    }
                    break;
                }else{ // 데이터가 일치하지 않을 경우
                    preNode = tempNode; // 한칸씩 앞으로 이동
                    tempNode = tempNode.link;
                }
            }
        }
    }

    // 마지막 Node 삭제
    public void deleteNode(){
        ListNode preNode;
        ListNode tempNode;

        // head노드가 널인 경우 모든 노드가 삭제되었으므로 return
        if(head == null){
            return;
        }

        // head 노드의 link가 널인 경우
        if(head.link == null){
            head = null;
        }else{ // 원소가 세개 이상일 때
            preNode = head;
            tempNode = head.link;

            while (tempNode.link != null){ // 마지막 노드로 이동
                preNode = tempNode; // 마지막 노드 이전 노드
                tempNode = tempNode.link; // 마지막 노드
            }
            preNode.link = null;
        }
    }

    // Node 탐색
    public ListNode searchNode(String data){
        ListNode tempNode = this.head;

        while (tempNode != null){
            if(data.equals(tempNode.getData())){
                return tempNode;
            }else{
                // 데이터가 일치하지 않을경우 다음 노드 할당
                tempNode = tempNode.link;
            }
        }
        return tempNode;
    }

    // 리스트의 노드 역순
    public void reverseList(){ // 1 2 3 4 5
        ListNode nextNode = head; // head가 참조하는 첫 번째 노드 할당
        ListNode currentNode = null;
        ListNode preNode = null;

        // 기준이 되는 nextNode를 통해 link를 바꿔준다
        while (nextNode != null){
            preNode = currentNode;
            currentNode = nextNode;
            nextNode = nextNode.link;
            currentNode.link = preNode;
        }
        head = currentNode;
    }

    // 연결리스트 모든 값 출력
    public void printList(){
        ListNode tempNode = this.head;

        while (tempNode != null){
            System.out.println(tempNode.getData() + " ");
            tempNode = tempNode.link;
        }
        System.out.println();
    }

}
