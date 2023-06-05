    public int sumOfMultiples(int n) {
        int cnt=0;
        for(int i=1; i<=n ; i++){
            if(i%3==0) cnt+=i;
            else if(i%5==0) cnt+=i;
            else if(i%7==0) cnt+=i;
        }
        return cnt;
    }
}