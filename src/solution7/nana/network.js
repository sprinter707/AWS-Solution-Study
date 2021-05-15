function dfs(n, computers, visited) {
  visited.add(n);
  for (let i = 0; i < computers.length; i++) {
    if (computers[n][i] && !visited.has(i)) {
      dfs(i, computers, visited);
    }
  }
}

function solution(n, computers) {
  var answer = 0;
  const visited = new Set();
  let i = 0;
  while (i < n) {
    if (visited.has(i)) {
      i += 1;
      continue;
    }
    answer += 1;
    dfs(i, computers, visited);
    i += 1;
  }
  return answer;
}

solution(3, [
  [1, 1, 0],
  [1, 1, 0],
  [0, 0, 1],
]);
solution(3, [
  [1, 1, 0],
  [1, 1, 1],
  [0, 1, 1],
]);
