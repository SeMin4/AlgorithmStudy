//
// Created by SeMin on 2020-03-12.
//

#include <iostream>
#include <queue>
using namespace std;
int  main(){
    queue<int> queue;
    int n;
    cin >> n;
    for(int i = 1; i<=n; ++i){
        queue.push(i);
    }
    int a;
    while(true){
        a = queue.front();
        queue.pop();
        if(queue.empty() ==true)
            break;
        queue.push(queue.front());
        queue.pop();
    }
    cout << a;
    return 0;
}