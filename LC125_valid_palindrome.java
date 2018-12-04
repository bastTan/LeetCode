
/*
 * 2ptr 
 *
 * check if a string is a palindrom.
 * only consider alphanumeric char, and numbers
 * ignoring case
 * node: empty string is valid palindrom in this question
 */

private boolean isAlphanumeric(char c) {
    return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0'  & c <= '9');
}

/* to lower
 * 1. Character.toLowerCase(c)
 * 2. if (c >= 'A' && c <= 'Z') c += 32;
 */
public boolean isPalindrome(String s) {
    if (s == null) throw new IllegalArgumentException();
    if (s.length() <= 1) return true;

    int l = 0;
    int r = s.length() - 1;
    for (; l < r; l++, r--) {
        while (l < r && !isAlphanumeric(s.charAt(l))) l++;
        while (l < r && !isAlphanumeric(s.charAt(r))) r--;
        if (l < r && Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r)))
            return false;
    }
    return true;
}
