function fakeSetTimeout(callback){
    callback();
}

console.log(0);

fakeSetTimeout(function(){
    console.log('hello');
});

console.log(1);