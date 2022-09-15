import java.util.Scanner;

public class BookShelf {
    int[][] memo;

    public int minHeightShelves(int[][] books, int shelf_width) {
        memo = new int[books.length + 1][shelf_width + 1];
        return minHeight(books, 0, shelf_width, 0, shelf_width);
    }

    public int minHeight(int[][] books, int cur, int widthLeft, int curHeight, int shelf_width) {
        System.out.println("(" + cur + "," + widthLeft + ")");
        if (cur == books.length) {
            return curHeight;
        }
        if (memo[cur][widthLeft] != 0) {
            System.out.println(cur + " :Cur " + widthLeft + " :WidthLeft " + curHeight + " :CurHeight ");
            return memo[cur][widthLeft];
        }
        memo[cur][widthLeft] = curHeight
                + minHeight(books, cur + 1, shelf_width - books[cur][0], books[cur][1], shelf_width);
        if (widthLeft >= books[cur][0]) {
            memo[cur][widthLeft] = Math.min(minHeight(books, cur + 1, widthLeft - books[cur][0],
                    Math.max(curHeight, books[cur][1]), shelf_width), memo[cur][widthLeft]);
        }
        return memo[cur][widthLeft];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] ar = new int[n][2];
        for (int i = 0; i < n; ++i) {
            ar[i][0] = in.nextInt();
            ar[i][1] = in.nextInt();
        }
        int wid = in.nextInt();
        BookShelf bk = new BookShelf();

        int res = bk.minHeightShelves(ar, wid);
        System.out.println(res);
        in.close();
    }
}
