/*
快速排序
在区间中随机挑选一个元素作基准，将小于基准的元素放在基准之前，
大于基准的元素放在基准之后，再分别对小数区与大数区进行排序。
递归法:
*/
void swap(int *x, int *y)
{
    int t = *x;
    *x = *y;
    *y = t;
}
void quick_sort_recursive(int arr[], int start, int end)
{
    if (start >= end)
        return;
    int mid = arr[end];
    int left = start, right = end - 1;
    while (left < right)
    {
        while (arr[left] < mid && left < right)
            left++;
        while (arr[right] >= mid && left < right)
            right--;
        swap(&arr[left], &arr[right]);
    }
    if (arr[left] >= arr[end])
        swap(&arr[left], &arr[end]);
    else
        left++;
    if (left)
        quick_sort_recursive(arr, start, left - 1);
    quick_sort_recursive(arr, left + 1, end);
}
void quick_sort(int arr[], int len)
{
    quick_sort_recursive(arr, 0, len - 1);
}
int main(void)
{
    int arr[5] = {5, 4, 3, 2, 1};
    quick_sort(arr, 5);
    return 0;
}