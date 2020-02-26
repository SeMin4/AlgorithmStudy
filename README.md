# 알고리즘 공부(C++ Basic)

## B_2711(string -> list 변환 과정)
string을 list로 변환해서 사용 하는 방법.
<pre><code>    std::list<std::string>::iterator it = mis_list.begin(); //auto로 사용도 가능
	std::advance(it, 2);//begin에서 부터 몇번째 떨어졋는지 advance 함수 기억하기
	auto it1 = std::next(listOfStrs.begin(), 2);// 또는 next 함수도 사용 가능
</code></pre>

<br>
<br>
<br>
<br>



