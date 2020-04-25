## PowerSet (멱집합 구하기)
### Recursive function 을 이용
### 완전 탐색
```c++
#include <iostream>
#include <vector>

using namespace std;

void Subset(vector<int> arr, vector<bool> &visit, int n, int idx);
void printSubset(vector<int> arr, vector<bool> &visit, int n);

int main(){
    int n;
    cin >> n;
    vector<int> arr (n, 0); // 부분집합을 만들기 위한 원래 집합
    vector<bool> visit(n, false); // 방문 여부를 판단하기 위해 만든 배열
    for(int i = 0; i< n; ++i){
        arr[i] = i + 1;
    }
    Subset(arr, visit, n, 0);
    return 0;
}

void Subset(vector<int> arr, vector<bool> &visit, int n, int idx){
    if (idx == n){//끝까지 간 경우에 출력
        printSubset(arr, visit, n);//현재 그곳을 방문했는지 아닌지를 체크하면서 출력
        return;
    }
    visit[idx] = false;// 방문 x
    Subset(arr,visit, n, idx + 1); //방문하려는 인덱스를 1개씩 늘려가면서 재귀 함수 이용
    visit[idx] = true; // 방문 o
    Subset(arr, visit, n, idx + 1);
}
void printSubset(vector<int> arr, vector<bool> &visit, int n){
    for(int i = 0; i < n; ++i){
        if(visit[i] == true){
            cout << arr[i] << ' ';
        }
    }
    cout << '\n';
}

```

## Permutation (순열 구하기)
### Recursive Function 을 이용

```c++
    #include <iostream>
#include <vector>

using namespace std;
void permutation(vector<int> arr, vector<int> &result, vector<bool> &visited, int n, int m);// permutation을 위한 재귀 함수
void print_permutation(vector<int> &result);// permutation을 출력하기
int main(){
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int n, m;
	cin >> n >> m;
	vector<int> arr(n, 0);
	for(int i = 0; i < n; ++i){
		arr[i] = i+1;
	}//permutation을 위한 배열 생성
	vector<bool> visited(n, false);// 방문정보를 담기 위한 배열
	vector<int> result; // 결과 배열
	permutation(arr, result, visited, n, m);
	return 0;
}

void permutation(vector<int> arr, vector<int> &result, vector<bool> &visited, int n, int m){
	if(m == 0){
		print_permutation(result);// 출력
		return;
	}
	for(int i = 0; i < n; ++i){
		if(visited[i] == true) // 이미 방문했다면 스킵 사용하는 이유는 중복을 피하기 위해서 사용
			continue;
		else{
			visited[i] = true;//방문하지 않은 경우 그것을 방문 기록을 남김
			result.push_back(arr[i]);// 결과 배열에 삽입
			permutation(arr, result, visited, n, m - 1 );// 한개를 뽑았기 때문에 m 을 1개 줄인후 다시 재귀함수
			visited[i] = false; //방문기록 삭제
			result.pop_back();// 결과배열에 빼기
		}
	}
}

void print_permutation(vector<int> &result){
	for(int i = 0; i < result.size(); ++i){
		cout << result[i] << ' ';
	}
	cout << '\n';
}


```

## Combination (조합)
### Recursive function을 이용

```c++
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
void combination(vector<int> arr, vector<bool> &visited, int  n, int r, int current_idx); // 조합을 구하기 위한 재귀 함수
void printcomb(vector<int> arr, vector<bool> &visited);// 조합을 출력
int main(){
	int n, r;
	cin >> n >> r;
	vector<int> arr(n, 0);
	vector<bool> visited(n, false);// 방문 배열
	for(int i = 0; i < n; ++i){
		arr[i] = i + 1;
	}// 조합을 구하기 위한 원래 배열 생성
	combination(arr,visited,  n, r, 0);
	return 0;
}

void combination(vector<int> arr, vector<bool> &visited, int n, int r, int current_idx){
	if(r == 0){// 원하는 갯수 만큼 뽑은 경우에 출력
		printcomb(arr, visited);
		return;
	}
	else{
		for(int i = current_idx; i < n; ++i){// 
			visited[i] = true;//그 숫자를 뽑겟다
			combination(arr, visited, n, r - 1, i+1); //current_idx 값을 1 증가 후 재귀 함수 호출 
            //증가의 이유는 현재 보다 더 낮은 인덱스들의 값들은 이미 사용했기 때문에 볼 필요가 없다.
			visited[i] = false;// 그 숫자를 뽑은 경우에서 없애기
		}
	}
}

void printcomb(vector<int> arr, vector<bool> &visited){
	for(int i = 0; i < arr.size(); ++i){
		if(visited[i] == true){
			 cout << arr[i] << ' ';
		}
	}
	cout << '\n';
}


```


## Overlap Combination(중복 조합)

### Recursive function을 이용

``` c++

#include <iostream>
#include <vector>

using namespace std;

void overlap_combination(vector<int> arr, vector<int> &result, int n, int r, int current_idx);// 중복조합을 위한 재귀 함수
void print_combination(vector<int> &result);// 출력을 위한 함수
int main(){
	int n, r;
	cin >> n >> r;
	vector<int> arr(n, 0);
	for(int i = 0; i<n; ++i){
		arr[i] = i+1;
	}//중복조합을 구하기 위한 원래 배열 구하기
	vector<int> result;
	overlap_combination(arr, result, n, r, 0);// 중복 조합 구하기
	return 0;
}
void overlap_combination(vector<int> arr, vector<int> &result, int n, int r, int current_idx){
	if(r == 0){//원하는 개수 만큼 뽑은 경우 출력 하기
		print_combination(result);
		return;
	}
	for(int i = current_idx; i < n; ++i){// 중복을 포함하여 반복을 통하여 재귀 함수 호출
		result.push_back(arr[i]);
		overlap_combination(arr, result, n, r-1, current_idx);// Combination 과 차이점 current_idx 값으로 현재의 current_idx값을 그대로 이용. 
		result.pop_back();
	}
}
void print_combination(vector<int> &result){
	for(int i = 0; i < result.size(); ++i){
		cout << result[i] << ' ';
	}
	cout << '\n';
}


```