function recur(nums, i, sum, target, cnt) {
  if (nums.length === i) {
    if (sum === target) cnt[0] += 1;
    return;
  }
  recur(nums, i + 1, sum + nums[i], target, cnt);
  recur(nums, i + 1, sum - nums[i], target, cnt);
}

// https://programmers.co.kr/learn/courses/30/lessons/43165
function solution(numbers, target) {
  let answer = [0];
  recur(numbers, 0, 0, target, answer);
  return answer[0];
}

console.log(solution([1, 1, 1, 1, 1], 3));
