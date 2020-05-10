//
// Created by SeMin on 2020-03-08.
//

#include <iostream>
#include <string>

using namespace std;
void OctToBin(int ,int);
int main(){
    string tmp;
    cin >> tmp;
    if(tmp == "0")
        cout << 0 <<'\n';
    else
        for(int i = 0; i<tmp.length(); ++i){
            OctToBin(tmp[i]-48, i);
        }
    return 0;
}
void OctToBin(int oct, int cnt){
    int arr[3];
    arr[2] = oct %2 ;
    oct /=2;
    arr[1] = oct %2;
    arr[0] = oct /2;

    if(cnt == 0){
        if(arr[0] == 0 && arr[1] == 0){
            cout << arr[2];

        }
        else if(arr[0] == 0){
            cout << arr[1] << arr[2];
        }
        else{
            for(int i = 0; i< 3; ++i){
                cout << arr[i];
            }
        }

    }
    else{
        for(int i = 0; i< 3; ++i){
            cout << arr[i];
        }
    }




}