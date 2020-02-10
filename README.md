# 알고리즘 공부(Data Structure & Algorithm)

## B_1874(시간초과)
c++언어의 특성상  시간초과의 문제가 발생. cin도 c언어의 scanf에 비해서 매우 느리다는 사실을 알게 되었고 endl을 사용하는 것이 '\n'을 사용하는 것보다 매우 느리다. 또한 다른 문제와는 다르게 모든 입력값을 배열에 한꺼번에 저장 해놓고 한꺼번에 처리하는 방식을 사용. 이것이 문제가 되는지는 정확하게 모르겠지만 받으면서 처리하는 것보다 빠르다는 사실을 알게 됨.
<pre><code>cout << endl  => cout << '\n'</code></pre>

<br>
<br>
<br>
<br>

## B_1406(시간초과)
string을 이용하여 문제를 풀이하였을 경우 모든 string 값을 수정하기 때문에 시간이 오래 걸린다. 따라서 list를 이용한다. string 값을 받고 
<pre><code> list\<char> ediotr(s.begin(),s.end());</code></pre>
를 이용하여 먼저 문자열을 리스트로 수정한다.
s.end(), s.begin()은 각각 반환형이 iterator 포인터를 반환한다. s.end() 의경우
<pre><code>for(string::iterator iter = str1.begin(); iter != str1.end(); ++iter){
  cout << *iter << endl
}</code></pre> 
같은 방식을 사용하여 많이 사용한다.
따라서 iterator 값으로 포인터를 통해 커서를 구하고 list.erase와 list.insert 함수를 통하여 구한다. 하지만 여기서 insert를 할 경우에는 iterator 포인터 값은 변하지 않는다. 주의 해야 할 부분은 erase 인데
<pre><code>if (cursor != editor.begin()) {
  cursor--;
  cursor = editor.erase(cursor);
}</code></pre>가장 마지막 부분이 삭제된다면 커서를 하나 앞 당긴다음 그부분을 삭제하고 그부분을 다시 cursor로 대입해주어야 한다.


