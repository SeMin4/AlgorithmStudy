#include <string>
#include <vector>
#include <algorithm>

using namespace std;


void insertHeap(vector<int> &heap, int value);
int deleteHeap(vector<int> &heap);

int solution(vector<int> scoville, int K) {
    int answer = 0;

	vector<int> heap(scoville.size() + 1, 0);
	heap[1] = scoville[0];
	for(int i = 2; i < heap.size(); ++i){
		heap[i] = scoville[i - 1];
		int idx = i;
		while(idx > 1){
			if(heap[idx/2] > heap[idx]){
				swap(heap[idx/2], heap[idx]);
			}
			else{
				break;
			}
			idx /= 2;
		}
	}
	
	while(heap[1] < K && heap.size() > 1){
		int first = deleteHeap(heap);
		int second = deleteHeap(heap);
		insertHeap(heap, first + second * 2);
		answer += 1;
	}
    if(heap.size() == 1)
        return -1;
    return answer;
}
int deleteHeap(vector<int> &heap){
	int value = heap[1];
	heap[1] = heap[heap.size() - 1];
	heap.pop_back();
	int idx = 1;
	while(true){
		int child = idx * 2;
		if(child >= heap.size())
			break;
		else if(child + 1 >= heap.size()){
			child = child;
		}
		else{
			if(heap[child] > heap[child + 1])
				child = child + 1;
		}
		if(heap[idx] > heap[child]){
			swap(heap[idx], heap[child]);
			idx = child;
		}else{
			break;
		}
	}
	return value;
}

void insertHeap(vector<int> &heap, int value){
	heap.push_back(value);
	int idx = heap.size() - 1;
	while(idx > 1){
		if(heap[idx/2] > heap[idx]){
			swap(heap[idx/2], heap[idx]);
		}
		else{
			break;
		}
		idx /= 2;
	}
}