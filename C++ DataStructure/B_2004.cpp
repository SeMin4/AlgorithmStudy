#include <iostream>
using namespace std;
int main() {
    long long ans2 = 0;
    long long ans5 = 0;
    int m,n;
    cin >> m >> n;
    for (long long i=2; i<=m; i*=2) {
        ans2 = ans2 + m/i;
    }
    for(long long i=2; i<=m-n; i*=2){
        ans2 = ans2 - (m-n)/i;
    }
    for(long long i=2; i<=n; i*=2){
        ans2 = ans2 - n/i;
    }

    for (long long i=5; i<=m; i*=5) {
        ans5 = ans5 + m/i;
    }
    for(long long i=5; i<=m-n; i*=5){
        ans5 = ans5 - (m-n)/i;
    }
    for(long long i=5; i<=n; i*=5){
        ans5 = ans5 - n/i;
    }

    if(ans2>ans5)
        cout<<ans5;
    else
        cout<<ans2;

    return 0;
}


