
	public void Add(int element) // 임의 값을 삽입할 때 리스트가 오름차순으로 정렬이 되도록 한다
	   {
	      Node1 newNode = new Node1(element);
	      if (first == null) {
	         // 리스트가 비어있을 경우, 새로운 노드 설정
	         first = newNode;
	      } else if (element < first.data) {
	         // 새로운 노드의 값이 첫 번째 노드의 값보다 작을 경우,
	         // 새로운 노드를 첫 번째 노드로 설정하고, 첫 번째 노드의 링크를 기존 첫 번째 노드로 변경합니다.
	         newNode.link = first;
	         // 새로운 노드의 값이 first값이 된다.
	         first = newNode;
	      } else {
	         Node1 current = first;
	         while (current.link != null && element > current.link.data) {
	            // 현재 노드의 다음 노드가 존재하고, 새로운 노드의 값이 다음 노드의 값보다 클 경우,
	            // 다음 노드로 이동
	            current = current.link;
	         }
	         // 새로운 노드의 링크를 이전 노드의 링크와 다음 노드의 링크 사이에 설정해준다.
	         newNode.link = current.link;
	         current.link = newNode;
	      }
	   }
	
