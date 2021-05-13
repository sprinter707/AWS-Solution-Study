function isAdjacent(a, b) {
  let cnt = 0;
  for (let i = 0; i < a.length; i++) {
    if (a[i] !== b[i]) {
      if (cnt === 1) return false;
      cnt += 1;
    }
  }
  return true;
}

function addEdge(adj, src, dst) {
  if (adj[src]) {
    adj[src].push(dst);
  } else {
    adj[src] = [dst];
  }
  if (adj[dst]) {
    adj[dst].push(src);
  } else {
    adj[dst] = [src];
  }
}

function getAdjacents(words) {
  const adj = {};
  for (let i = 0; i < words.length; i++) {
    for (let j = i + 1; j < words.length; j++) {
      if (isAdjacent(words[i], words[j])) {
        addEdge(adj, words[i], words[j]);
      }
    }
  }
  return adj;
}

// https://programmers.co.kr/learn/courses/30/lessons/43163
function solution(begin, target, words) {
  var answer = 0;

  words.push(begin);
  const adj = getAdjacents(words);
  if (!adj[target]) return 0;

  // bfs
  const visited = new Set([begin]);
  const prev = {};
  const q = [begin];
  while (q.length > 0) {
    let node = q.pop(0);
    if (node === target) {
      break;
    }
    for (let neighbor of adj[node]) {
      if (!visited.has(neighbor)) {
        q.push(neighbor);
        visited.add(neighbor);
        prev[neighbor] = node;
      }
    }
  }

  if (!prev[target]) return 0;

  // find from end to begin
  let node = target;
  while (node !== begin) {
    node = prev[node];
    answer += 1;
  }

  return answer;
}

console.log(solution('hit', 'cog', ['hot', 'dot', 'dog', 'lot', 'log', 'cog']));
console.log(solution('hit', 'cog', ['hot', 'dot', 'dog', 'lot', 'log']));
