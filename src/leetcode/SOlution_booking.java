package leetcode;
import java.util.*;

class SOlution_booking {

    static class Booking {
        int userId;
        int resId;
        int checkIn;
        int checkOut;

        Booking(int userId, int resId, int checkIn, int checkOut) {
            this.userId = userId;
            this.resId = resId;
            this.checkIn = checkIn;
            this.checkOut = checkOut;
        }
    }

    static class Pair {
        int resId;
        int checkOut;

        Pair(int resId, int checkOut) {
            this.resId = resId;
            this.checkOut = checkOut;
        }
    }

    public static Map<Integer, List<List<Integer>>> findBookings(List<Booking> bookings) {
        Map<Integer, List<List<Integer>>> res = new HashMap<>();
        if (bookings == null || bookings.size() == 0) {
            return res;
        }
        Map<Integer, TreeMap<Integer, List<Pair>>> map = new HashMap<>();
        for (Booking booking : bookings) {
            map.putIfAbsent(booking.userId, new TreeMap<>());
            map.get(booking.userId).putIfAbsent(booking.checkIn, new ArrayList<>());
            map.get(booking.userId).get(booking.checkIn).add(new Pair(booking.resId, booking.checkOut));
        }
        for (int userId : map.keySet()) {
            TreeMap<Integer, List<Pair>> graph = map.get(userId);
            dfs(graph, graph.firstKey(), new ArrayList<>(), res, userId);
        }
        return res;
    }

    private static void dfs(TreeMap<Integer, List<Pair>> graph, int checkIn, List<Integer> cur,
                     Map<Integer, List<List<Integer>>> res, int userId) {
        if (!graph.containsKey(checkIn)) {
            if (cur.size() >= 2) {
                res.putIfAbsent(userId, new ArrayList<>());
                res.get(userId).add(new ArrayList<>(cur));
            }
            return;
        }
        for (Pair pair : graph.get(checkIn)) {
            cur.add(pair.resId);
            dfs(graph, pair.checkOut, cur, res, userId);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args){
        List<Booking> bookings = new ArrayList<>();
        bookings.add(new Booking(1,1001,100,101));
        bookings.add(new Booking(2,1002,104,105));
        bookings.add(new Booking(1,1003,101,103));
        bookings.add(new Booking(3,1004,104,105));
        bookings.add(new Booking(3,1005,105,107));
        bookings.add(new Booking(4,1006,106,108));
        bookings.add(new Booking(4,1007,108,110));
        bookings.add(new Booking(4,1008,108,109));
        bookings.add(new Booking(4,1009,110,112));
        bookings.add(new Booking(4,1010,109,113));
        System.out.println(findBookings(bookings));
    }
}
