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