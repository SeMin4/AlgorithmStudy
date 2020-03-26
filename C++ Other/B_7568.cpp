//
// Created by SeMin on 2020-03-13.
//

#include <iostream>
using namespace  std;
class Person{
public:
    int weight;
    int height;
};
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int size;
    cin >> size;
    Person *arr = new Person[size];
    for(int i = 0; i< size; ++i){
        int tmp1, tmp2;
        cin >> tmp1 >> tmp2;
        arr[i].weight = tmp1;
        arr[i].height = tmp2;
    }
    for(int i = 0; i<size; ++i){
        int out = 0;
        for(int j = 0; j<size; ++j){
            if(i ==j)
                continue;
            else{
                if(arr[i].weight < arr[j].weight){
                    if(arr[i].height < arr[j].height){
                        out += 1;
                    }
                }
            }

        }
        cout << out +1 << ' ';
    }
    return 0;
}
