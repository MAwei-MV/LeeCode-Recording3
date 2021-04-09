package Main;

public class Pro605 {
    public static void main(String args[]) {
        Pro605 p = new Pro605();
        int a[] = {0, 0, 1, 0, 1};
        System.out.println(p.canPlaceFlowers(a, 2));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0, len = flowerbed.length; i < len && n > 0; ) {
            if (flowerbed[i] == 1) {
                i += 2;
            } else if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
                n--;
                i += 2;
            } else {
                i += 3;
            }
        }
        return n <= 0;
    }
}