var arr = read_line().split(/\s+/).map((item) => {
    return +item
}),N=arr[0],M=arr[1];

function minnum(N,M){
var mid=Math.ceil(M/2),cnt=0;//上取整
if(N==M){
print(0);
return
}else if(N==(M/2)){
print(1)
return
}else if(N<M&&N>mid){
while(N>mid){
cnt++;
N--;
}
N=N*2;
cnt++;
if(N==M){
print(cnt);
return
}
if(N>M){
cnt+=N-M
print(cnt);
return 
}
}else if(N<M&&N<mid){
while(N<M){
N=N*2;
cnt++;
print(N)
}
if(N==M){
print(cnt);
return
}
if(N>M){
cnt+=N-M
print(cnt);
return 
}
}else if(N>M){
print(N-M)
return
}
}
minnum(N,M)