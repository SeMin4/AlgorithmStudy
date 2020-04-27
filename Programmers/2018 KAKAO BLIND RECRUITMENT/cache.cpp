#include <string>
#include <vector>
#include <algorithm>
#include <cctype>
using namespace std;


int solution(int cacheSize, vector<string> cities) {
    int answer = 0;
    if (cacheSize == 0){
        return 5 * cities.size();
    }
	vector<string> cache;
	for(int i = 0; i < cities.size(); ++i){
		transform(cities[i].begin(), cities[i].end(), cities[i].begin(), ::tolower);
		vector<string>::iterator iter = find(cache.begin(), cache.end(), cities[i]);
		if(iter != cache.end()){
			answer += 1;
			cache.erase(iter);
			cache.push_back(cities[i]);
		}
		else{
			answer += 5;
			if(cache.size() == cacheSize){
				cache.erase(cache.begin());
				cache.push_back(cities[i]);
			}else{
				cache.push_back(cities[i]);
			}
		}
	}
    return answer;
}