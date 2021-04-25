function myFunction(p1, p2) {
  return p1 * p2;
}
//getElement : tag를 찾을 건데 어떤 태그를 찾을 거냐
//             -> tag가 demo인 걸 찾겠다
document.getElementById("demo").innerHTML = myFunction(4, 3);