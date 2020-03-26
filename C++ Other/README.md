## B_1152 (string trim function & inline function)
```c++
#include <iostream>
#include <string>
#include <cstring>
using namespace std;
// 또한 함수의 반환형이 inline이기 때문에 그냥 함수에 비해서 속도가 빠르다는 장점이 있다. 
//string::npos는 find함수에서 많이 사용!! 왜냐하면 find함수에서 그 str값을 찾지 못할때 이 값을 반환하기 때문
// string에 해당하는 trim함수를 직접 만들어서 그부분에 해당 하는 부분을 없애는 trim 함수.
inline string trim_left(const string& str){
    int n = str.find_first_not_of(" \t\v\n");//처음부터 공백을 제외하고 시작하는 부분 찾기
    return n == string::npos ? str : str.substr(n, str.length()); //그 부분과 string::npos 가 같다라는 것은 찾지 못했다 라는 것이다. 찾지못했다면 str을 그대로 반환 아니면 substr을 이용해서 잘라서 반환
}
// string에 해당하는 trim함수를 직접 만들어서 그부분에 해당 하는 부분을 없애는 trim 함수.
inline string trim_right(const string& str){
    int n = str.find_last_not_of(" \t\v\n");//처음부터 공백을 제외하고 시작하는 부분 찾기
    return n == string::npos ? str : str.substr(0, n+1);//그 부분과 string::npos 가 같다라는 것은 바로 끝부분에 있다라는 것. 찾지못했다면 str을 그대로 반환 아니면 substr을 이용해서 잘라서 반환
}
int main(){
    string tmp;
    int cnt = 0;
    getline(cin, tmp);
    tmp = trim_left(tmp);
    tmp = trim_right(tmp);
    char *buffer = new char[tmp.length() + 1];
    strcpy(buffer, tmp.c_str());
    char *tok = strtok(buffer, " ");
    while(tok != nullptr){
        cnt+=1;
        tok = strtok(nullptr, " ");
    }
    cout << cnt << '\n';

    return 0;

}
```

<br>
<br>
<br>
<br>

## 인라인 함수(출처 : https://shaeod.tistory.com/366)
※요약

인라인 함수는 프로그램의 실행 속도를 높이기 위해 추가된 기능이며 C언어의 매크로 함수와 비교된다.



(개발자 입장에서)일반 함수와 인라인 함수의 가장 큰 차이점은 함수의 호출 방식이다. 일반 함수의 호출 방법은 프로그램 실행 중 함수를 실행해야하면 해당 함수의 주소로 점프시켰다가, 함수의 처리가 종결되면 다시 원래의 자리로 돌아오는 것이다. 이렇게 앞뒤로 점프를 수행하고, 점프할 위치를 기억하려면 함수를 사용하는데 시간이 많이 걸린다.



인라인 함수는 컴파일된 함수 코드가 프로그램의 코드 안에 직접 삽입되어진다. 이 말은 컴파일러가 함수를 호출하는 대신, 그에 대응하는 함수 코드로 대체한다는 것을 의미하며 함수 호출없이 삽입된 함수 코드를 그 자리에서 처리하므로 해당 함수를 수행하기 위해 프로그램이 다른 주소로 점프했다가 되돌아 올 필요가 없어 속도면에서 유리하다.



※특징

- 인라인 함수를 사용하려면 함수 선언 앞에 inline이라는 키워드를 붙이거나 함수 정의 앞에 inline이라는 키워드를 붙인다.

- 클래스 멤버 함수가 inline을 사용하려면, 함수 정의의 위치가 *.h에 있어야 한다. 안 그러면 확인할 수 없는 외부 참조라고 뜬다.

- 프로그래머가 inline 선언을 해도 컴파일러가 인라인화를 거부할 수 있다.

- 프로그래머가 inline 선언을 안 해도 컴파일러가 인라인화를 할 수 있다.

- 함수의 덩치가 크거나 재귀호출이면 inline 요구를 거절하는 컴파일러도 있다.

- 함수 코드의 수행 시간이 짧고 빈번하게 호출되는 함수가 아니라면, 인라인 함수로 인한 절대적인 시간 절약은 그다지 크지 않다.

※장점

- 함수가 인라인화 되어 성능의 향상으로 이어질 수 있다.



※단점

- 메모리 사용 측면에서는 인라인 함수가 일반 함수보다 불리하다. 이유는 어떤 프로그램에서 인라인 함수를 열 번 호출한다면, 프로그램은 그 함수의 사본을 프로그램의 코드 안에 열 번이나 삽입해야 하기 때문이다.

- 매크로 함수와 달리 자료형에 독립적이지 못 하다. 단, 템플릿을 이용하면 자료형에 독립적으로 사용할 수 있다.





※예제
```c++
#include <iostream>

using namespace std;

inline void Test( int nNum1 );

int main( )
{
	Test( 2 );

	return 0;
}

void Test( int nNum1 )
{
	int nResult = nNum1;
}
```
<br>
<br>
<br>
<br>

## B_11050 (이항계수 점화식 dp를 이용하여 풀기)
```c++
//
// Created by SeMin on 2020-03-12.
//

#include <iostream>
long long dp[11][11];
using namespace std;
int main(){
    int n, k;
    cin >> n >> k;
    for(int i = 0; i<11; ++i){
        dp[i][0] = 1;
    }
    dp[1][1] = 1;
    //이항 계수 점화식을 이용하여 dp를 이용하여 푼다
    //nC(r-1) + nCr = n+1Cr과 같다는 점화식을 이용한다.
    for(int i = 2; i<11; ++i){
        for(int j = 1; j<= i; ++j){
            dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
        }
    }
    cout << dp[n][k];

}
```

<br>
<br>
<br>
<br>

## B_1181 (#include &lt;algorithm> 안에 있는 find 함수)
```c++
//
// Created by SeMin on 2020-03-12.
//

#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

bool myRank(string &a, string &b){
    if(a.length() == b.length())
        return a < b;

    return a.length() < b.length();
}
int main(){
    int test_case;
    cin >> test_case;
    vector<string> arr;
    for(int i = 0; i< test_case; ++i){
        string tmp;
        cin >> tmp;
        //find 함수를 잘 알아둘것 algortihm STL 의 함수로 str.find와는 다르다. 반복자를 리턴하고 만약에 찾는 값이 없는 경우에는 end를 리턴한다.
        if(find(arr.begin(), arr.end(), tmp) == arr.end())
            arr.push_back(tmp);
    }
    sort(arr.begin(), arr.end(), myRank);
    for(int i = 0; i< arr.size(); ++i){
        cout << arr[i]<<'\n';
    }
    return 0;
}
```

<br>
<br>
<br>
<br>

## C++ 다형성(Polymorphism)
c++은 다형성을 위해서 함수를 오버로딩(Overloading)에 의해서 사용하기도 하지만 template을 이용할 수도 있다

### 함수 템플릿(Function Template)
- 함수를 만들어 낼때, 함수의 기능은 명확하지만 자료형을 모호하게 두는 것.

```c++
int sum(int a, int b){
    return a + b;
}
double sum(double a, double b){
    return a + b;
}
```

```c++
template <typename T>
T sum(T a, T b){
    return a + b;
}
```

``` c++
template <class T1, class T2>
void printAll(T1 a, T2 b){
    cout << a;
    cout << b;
    cout << a + b;
}
```

- 호출시
```c++
sum<int>(a + b);
sum<double>(a + b);
```
- 함수 호출할때 명확하게 어떤 자료형을 쓸건지 < >안에 표시해주는게 좋다. 하지만 template으로 사용하는 변수가 2개 이상인 경우에는 함수이름 뒤 <> 안에 명확하게 사용하지 않는다.
- 그때에는 컴파일러가 스스로 자료형을 판단
``` c++
printAll(str1 ,str2);
printAll(str1, num1);
````

<br>
<br>
<br>
<br>

## B_10816 (map을 이용한 dictionary 형태의 자료구조)
```c++
//
// Created by SeMin on 2020-03-13.
//

#include <map>
#include <iostream>
using namespace std;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    map<int, int> arr;
    int size;
    cin>> size;
    for(int i = 0; i<size; ++i){
        int tmp;
        cin >> tmp;
        //키값을 찾는거
        if(arr.find(tmp)!= arr.end()) {
            arr[tmp]++;
        }
        else{
            arr[tmp] = 1;
        }
    }
    //map 에 관한 부분으로 잘 알아놓자!! 이터레이터
    //map은 키값을 기준으로 하여 자동으로 정렬이 된다.
//    map<int, int>::iterator iter;
//    for(iter = arr.begin(); iter != arr.end(); ++iter){
//        cout << iter->first  << ": " << iter->second<< '\n';
//    }
    int find_size;
    cin >> find_size;
    for(int i = 0; i<find_size; ++i){
        int tmp;
        cin >> tmp;
        if(arr.find(tmp) != arr.end()){
            cout << arr[tmp] <<' ';
        }
        else
            cout << 0 <<' ';
    }
    return 0;
}
```

<br>
<br>
<br>
<br>

## c++ (map)
### Map
- #inlcude &lt;map>을 적어야 사용이 가능 한 자료구조 
- key와 value에 쌍으로 저장되는 map
- 노드 기반으로 이루어져 있는 균형 이진 트리 구조
- Unique Key로key는 고유한 값이므로 중복이 불가능 하다
- Ordered한 속성을 가지고 있어 map도 set과 마찬가지로 삽입이 되면서 자동으로 정렬이 됩니다.
```c++
#include<iostream>
#include<map>
#include<string>
using namespace std;
 
int main(void){
    
    map<int, string> m;
    
    m.insert(pair<int, string>(40, "today"));
    m.insert(pair<int, string>(35, "ms"));
    m.insert(pair<int, string>(10, "trot"));
    m.insert(pair<int, string>(90, "2"));
    m.insert(pair<int, string>(65, "kyungpook"));
    m.insert(pair<int, string>(20, "National"));
    m.insert(pair<int, string>(50, "Univ"));
 
    
    map<int, string>::iterator iter;
    
    //접근방법 1  first, second 로 하는 방법을 주의깊게 볼것.
    for(iter = m.begin(); iter != m.end(); iter++){
        cout << "[" << iter->first << ", " << iter->second << "]" << " " ;
    }
    cout << endl;
    
    //접근방법 2 
    for(iter = m.begin(); iter != m.end(); iter++){
        cout << "[" << (*iter).first << ", " << (*iter).second << "]" << " " ;
    }
    
    
    return 0;    
}

```
