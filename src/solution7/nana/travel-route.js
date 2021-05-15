function getAdjacent(tickets) {
  const adj = {};
  for (let [src, dst] of tickets) {
    if (adj[src]) {
      adj[src].push(dst);
    } else {
      adj[src] = [dst];
    }
  }
  Object.keys(adj).forEach((key) => {
    adj[key].sort((a, b) => {
      if (a < b) return 1;
      if (a > b) return -1;
      return 0;
    });
  });
  return adj;
}

function dfs(ans, adj, src, cnt) {
  ans.push(src);
  if (cnt === 0) return true; // 티켓 다 씀
  if (adj[src]) {
    for (let i = 0; i < adj[src].length; i++) {
      let dist = adj[src].pop();
      if (dfs(ans, adj, dist, cnt - 1)) return true;
      adj[src].unshift(dist);
    }
  }
  ans.pop();
  return false;
}

function solution(tickets) {
  var answer = [];
  const adj = getAdjacent(tickets);
  dfs(answer, adj, 'ICN', tickets.length);
  return answer;
}

console.log(
  solution([
    ['ICN', 'JFK'],
    ['HND', 'IAD'],
    ['JFK', 'HND'],
  ])
);
console.log(
  solution([
    ['ICN', 'SFO'],
    ['ICN', 'ATL'],
    ['SFO', 'ATL'],
    ['ATL', 'ICN'],
    ['ATL', 'SFO'],
  ])
);
console.log(
  solution([
    ['ICN', 'COO'],
    ['ICN', 'BOO'],
    ['COO', 'ICN'],
  ])
);
