//
// Created by SeMin on 2020-03-12.
//

#include <iostream>
using namespace std;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int test_case;
    cin >> test_case;
    while(test_case > 0){
        int h, w, n;
        int result = 0;
        cin >> h >> w >> n;
        if((n % h) != 0){
            result += (n % h * 100);
            result += (n / h +1 );
        }
        else{
            result += h * 100;
            result += (n / h);
        }
        cout << result << '\n';
        test_case--;
    }
    return 0;

}