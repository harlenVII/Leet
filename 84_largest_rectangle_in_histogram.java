c class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int top = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                res = Math.max(res, heights[top] * width);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int width = stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1;
            res = Math.max(res, heights[top] * width);
        }
        return res;
    }
}


// class Solution {
// public:
//     int largestRectangleArea(vector<int>& height) {
//         height.insert(height.begin(),0); // dummy "0" added to make sure stack s will never be empty
//         height.push_back(0); // dummy "0" added to clear the stack at the end
//         int len = height.size();
//         int i, res = 0, idx;
//         stack<int> s; // stack to save "height" index
//         s.push(0); // index to the first dummy "0"
//         for(i=1;i<len;i++)
//         {
//             while(height[i]<height[idx = s.top()]) // if the current entry is out of order
//             {
//                 s.pop();
//                 res = max(res, height[idx] * (i-s.top()-1) ); // note how the width is calculated, use the previous index entry
//             }
//             s.push(i);
//         }
//         height.erase(height.begin()); // remove two dummy "0"
//         height.pop_back();
//         return res;
//     }
// };
