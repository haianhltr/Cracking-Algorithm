class Solution {
    Set<Integer> set = new HashSet();
    public boolean canFinish(int n, int[][] prerequisites) {
        ArrayList<Integer> [] prereqs = new ArrayList[n];
        int [] count = new int [n];
        for(int k = 0; k < n; k++)
        {
            prereqs[k] = new ArrayList();
        }
        
        for(int [] temp : prerequisites)
        {
            count[temp[0]]++;
            prereqs[temp[1]].add(temp[0]);
        }
        
        
        for(int k = 0; k < count.length; k++)
        {
            
            if(count[k] == 0)
            {
                if(!set.contains(k))
                {
                      n = DFS(prereqs, count, n, k);
                }
              
                
            }
        }
        
        return n== 0 ? true : false;
    }
    
    public int DFS(ArrayList<Integer> [] prereqs, int [] count, int n, int num)
    {
        set.add(num);
        n--;
        if(prereqs[num].size() == 0)
        {
            return n;
        }
        
        for(int temp : prereqs[num])
        {
            count[temp]--;
            if(count[temp] == 0)
            {
                n = DFS(prereqs, count, n, temp);
            }
        }
        
        return n;
    }
}