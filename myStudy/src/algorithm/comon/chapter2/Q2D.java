package algorithm.comon;

public class Q2D {
    // 문자열의 사전 순 대소관계 비교를 위한 함수 compare(s1, s2)만들기 -> s1이 s2보다 빠르면 음수, 동일하면 0, 느리다면 양수 반환
    // 문자열의 일치여부 확인을 위한 equals(s1, s2)만들기 -> 일치하면 true, 일치하지 않으면 false 반환

    // 사전 순 대소관계 비교 함수
    public static int compare(char[] s1, char[] s2) {
        int n = Math.min(s1.length, s2.length);
        for(int i = 0; i < n; i++) {
            if(s1[i] != s2[i]) {
                return (int)s1[i] - s2[i];
            }
        }
        return  s1.length - s2.length;
    }

    // 문자열 일치 함수
    public static boolean equals(char[]s1, char[] s2){
        // 길이가 일치하지않는 경우
        if(s1.length != s2.length){ // 이 조건만 해도 엄청많은 데이터가 스킵
            return false;
        }
        // 길이가 일치하는 경우
        for(int i = 0; i < s1.length; i++){
            if(s1[i] != s2[i]){
                return false; // 가지치기
            }
        }
        return true;
    }
    public static void main(String[] args) {
        char[] s1 = "algorithm".toCharArray(); // toCharArray() = 문자열을 char배열로 변경하는 함수
        char[] s2 = "allergy".toCharArray();

        System.out.printf("compare() Result : %d\n", compare(s1,s2) );
        System.out.printf("equals() Result : %b\n", equals(s1,s2) );
    }
}
