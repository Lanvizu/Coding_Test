import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int length = data.length;
        ArrayList<int[]> arrayList = new ArrayList<>();


        for (int i = 0; i < length; i++) {
            if (ext.equals("date") && data[i][1] < val_ext) {
                arrayList.add(data[i]);
            } else if (ext.equals("code") && data[i][0] < val_ext) {
                arrayList.add(data[i]);
            } else if (ext.equals("maximum") && data[i][2] < val_ext) {
                arrayList.add(data[i]);
            } else if (ext.equals("remain") && data[i][3] < val_ext) {
                arrayList.add(data[i]);
            }
        }
        if (sort_by.equals("remain")) {
            arrayList.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o1[3], o2[3]);
                }
            });
        }else if (sort_by.equals("code")) {
            arrayList.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o1[0], o2[0]);
                }
            });
        }else if (sort_by.equals("date")) {
            arrayList.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o1[1], o2[1]);
                }
            });
        }else if (sort_by.equals("maximum")) {
            arrayList.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o1[2], o2[2]);
                }
            });
        }
        int[][] answer = new int[arrayList.size()][];
        for (int i = 0; i < arrayList.size(); i++) {
            answer[i] = arrayList.get(i);
        }

        // String[] arr = {"code","date","maximum","remain"};
        // List<String> columnList = Arrays.asList(arr);
        // int extIdx = columnList.indexOf(ext);
        // int sortIdx = columnList.indexOf(sort_by);
        // int[][] answer = Arrays.stream(data).filter(o1 -> o1[extIdx] < val_ext)
        //     .sorted((o1 ,o2) -> o1[sortIdx]-o2[sortIdx]).toArray(int[][]::new);
        
        return answer;
    }
}
