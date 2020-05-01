#include <string>
#include <vector>

#include <algorithm>

using namespace std;

vector<int> solution(int brown, int red) {
    vector<int> answer;
	int area = brown + red;
	for(int width = 3; ; ++width){
		if(area % width == 0){
			int height = area / width;
			if((width - 2)*(height-2) == red){
				if(width < height){
					swap(width, height);
				}
				answer.push_back(width);
				answer.push_back(height);
				break;
			}
		}
	}
    return answer;
}