#include <string>
#include <vector>

#include <map>

using namespace std;

map<long long, long long> room;

long long hotelroom(long long num);

vector<long long> solution(long long k, vector<long long> room_number) {
    vector<long long> answer;
	for(int i = 0; i < room_number.size(); ++i){
		long long find_room = hotelroom(room_number[i]);
		answer.push_back(find_room);
		room[find_room] = find_room + 1;
	}
    return answer;
}
long long hotelroom(long long num){
	if(!room[num]){
		return num;
	}
	return room[num] = hotelroom(room[num]);
}