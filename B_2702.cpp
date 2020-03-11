//
// Created by SeMin on 2020-03-08.
//

#include <iostream>
#include <algorithm>
using namespace std;
int gcd (int , int );
int mcm(int , int, int );
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int test_case;
    cin >> test_case;
    while (test_case > 0){
        int a, b;
        cin >> a >> b;
        int gc = gcd(a, b);
        int mc = mcm(a, b, gc);
        cout << mc << ' '<< gc << '\n';
        test_case--;
    }
    return 0;
}
int gcd(int a, int b){
    if(b > a){
        swap(a,b);
    }
    int c, d;
    while(a % b != 0){
        c = b;
        d= a % b;
        a = c;
        b = d;
    }
    return b;
}
int mcm(int a, int b, int c){
    return (a/c) * (b/c) * c;
}
