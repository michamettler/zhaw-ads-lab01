package ch.zhaw.ads.solutions;

import ch.zhaw.ads.CommandExecutor;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WellformedXmlServer implements CommandExecutor {

    ListStack xmlStack;

    @Override
    public String execute(String s) throws Exception {
        return Boolean.toString(checkWellformed(s));
    }

    public boolean checkWellformed(String s) {
        xmlStack = new ListStack();

        String[] tokens = s.split("<");
        ArrayList<String> tokenList = new ArrayList<>(List.of(tokens));
        if (tokenList.get(0).isEmpty()) {
            tokenList.remove(0);
        } else {
            return false;
        }

        for (var token : tokenList) {
            if (!token.contains("/>")) {
                if (token.charAt(0) != '/') {
                    token = token.substring(0, token.length() - 1);

                    if (isTokenIndependent(token)) {
                        xmlStack.push(token);
                    } else {
                        xmlStack.push(token.split(" ")[0]);
                    }

                } else {
                    token = token.substring(1);
                    token = token.substring(0, token.length() - 1);
                    if (xmlStack.peek() != null && token.equals(xmlStack.peek().toString())) {
                        xmlStack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }

        return xmlStack.isEmpty();
    }

    private boolean isTokenIndependent(String token) {
        if (token == null) return false;
        return token.matches("<[a-zA-Z\\s]+/>");
    }


}
