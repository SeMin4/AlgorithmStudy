#include<iostream>
#include<set>
using namespace std;
int Z, N, M;
int ret[1000001];
int arr[1000001];
bool chk(){
    set<int> treeSet;
    for (int i = 1; i <= M; i++) {
        int t;
        cin >> t;
        if(t == 0){//비가 안올때..
            treeSet.insert(i);
            ret[i] = 0;
        }
        else{//비가 올때..
            set<int>::iterator day = treeSet.upper_bound(arr[t]);
            if(day == treeSet.end()){
                i++;
                while(i <= M){
                    cin >> t;
                    i++;
                }
                return false;
            }
            ret[*day] = t;
            arr[t] = i;
            treeSet.erase(day);
        }
    }
    return true;
}


int main(){
//    freopen("C:\\Users\\SeMin\\Desktop\\e\\e1.in", "r", stdin);
//    freopen("C:\\Users\\SeMin\\Desktop\\e\\e1out.txt", "w", stdout);
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    cin >> Z;
    for (int i = 0; i < Z; i++) {
        cin >> N >> M;
        for (int j = 1; j <= M; j++) {
            arr[j] = ret[j] = -1;
        }
        if(chk()){
            cout << ("YES\n");
            for (int j = 1; j <= M; j++) {
                if(ret[j] != -1)
                    cout << ret[j] <<  " ";
            }
            cout << '\n';
        }else{
            cout << "NO\n";
        }
    }
}
