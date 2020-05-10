#include <vector>
#include <queue>

using namespace std;
int M, N;
int bfs(int i, int j, vector<vector<bool>> &visited, vector<vector<int>> matrix){
    visited[i][j] = true;
    queue<pair<int, int>> q;
    int area = 0;
    int current_color = matrix[i][j];
    vector<pair<int, int>> dimension;
    dimension.push_back(make_pair(0, -1));
    dimension.push_back(make_pair(-1, 0));
    dimension.push_back(make_pair(0, 1));
    dimension.push_back(make_pair(1, 0));
    q.push(make_pair(i, j));
    while(!q.empty()){
        area ++;
        int y = q.front().first;
        int x = q.front().second;
        
        for(int i = 0; i < dimension.size(); ++i){
            int tmpy = y + dimension[i].first;
            int tmpx = x + dimension[i].second;
            if(tmpy < 0 || tmpy > M - 1 || matrix[tmpy][tmpx] != current_color || visited[tmpy][tmpx] == true){
                continue;
            }else if(tmpx < 0 || tmpx > N - 1 || matrix[tmpy][tmpx] != current_color || visited[tmpy][tmpx] == true){
                continue;
            }else{
                q.push(make_pair(tmpy, tmpx));
                visited[tmpy][tmpx] = true;
            }
        }
        q.pop();
    }
    return area;
}

// 전역 변수를 정의할 경우 함수 내에 초기화 코드를 꼭 작성해주세요.
vector<int> solution(int m, int n, vector<vector<int>> picture) {
    M = m;
    N = n;
    int number_of_area = 0;
    int max_size_of_one_area = 0;
    vector<vector<bool>> visited(m, vector<bool>(n,false));
    
    for(int i = 0; i < m; ++i){
        for(int j = 0; j < n; ++j){
            if(visited[i][j] == false && picture[i][j] != 0){
                
                int area = bfs(i, j, visited, picture);
                
                if(max_size_of_one_area < area){
                    max_size_of_one_area = area;
                }
                number_of_area += 1;
                
            }
        }
    }
    
    
    
    
    vector<int> answer(2);
    
    answer[0] = number_of_area;
    answer[1] = max_size_of_one_area;
    
    return answer;
}