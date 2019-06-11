package com.ZPI.group1.CurrencyData;

public class CurrencySession {
    CurrencyTable currencyTable;

    public CurrencySession(CurrencyTable currencyTable) {
        this.currencyTable = currencyTable;
    }

    public int getCurrencyDownwardSessionAmount() {
        InnerClassForSession innerClassForSession=new InnerClassForSession(0,false,0,currencyTable.rates.get(0));
        for (innerClassForSession.i = 1; innerClassForSession.i < currencyTable.rates.size(); innerClassForSession.i++) {
            if (innerClassForSession.lastRate.mid > currencyTable.rates.get(innerClassForSession.i).mid) {
                innerClassForSession.result=checkSessionEnds(innerClassForSession);
            } else {

                innerClassForSession.result=checkSessionBegin(innerClassForSession);
            }
        }
        return innerClassForSession.result;
    }

    public int getCurrencyGrowthSessionAmount() {
        InnerClassForSession innerClassForSession=new InnerClassForSession(0,false,0,currencyTable.rates.get(0));
        for (innerClassForSession.i = 1; innerClassForSession.i < currencyTable.rates.size(); innerClassForSession.i++) {
            if (innerClassForSession.lastRate.mid < currencyTable.rates.get(innerClassForSession.i).mid) {
                innerClassForSession.result=checkSessionEnds(innerClassForSession);
            } else {

                innerClassForSession.result=checkSessionBegin(innerClassForSession);
            }
        }
        return innerClassForSession.result;
    }

    public int getCurrencyConstantSessionAmount() {
        InnerClassForSession innerClassForSession=new InnerClassForSession(0,false,0,currencyTable.rates.get(0));
        for (innerClassForSession.i = 1; innerClassForSession.i < currencyTable.rates.size(); innerClassForSession.i++) {
            if (innerClassForSession.lastRate.mid == currencyTable.rates.get(innerClassForSession.i).mid) {

                innerClassForSession.result=checkSessionEnds(innerClassForSession);
            } else {

                innerClassForSession.result=checkSessionBegin(innerClassForSession);
            }
        }
        return innerClassForSession.result;
    }

    private int checkSessionEnds(InnerClassForSession session){
        if (session.i == currencyTable.rates.size() - 1 && session.sessionStarted) {
            session.result++;
        }
        session.sessionStarted = true;
        session.lastRate = currencyTable.rates.get(session.i);
        return session.result;
    }
    private int checkSessionBegin(InnerClassForSession session){
        if (session.i > 1 && session.sessionStarted) {
            session.lastRate = currencyTable.rates.get(session.i);
            session.sessionStarted = false;
            session.result++;
        } else {
            session.lastRate = currencyTable.rates.get(session.i);
        }
        return session.result;
    }
    class InnerClassForSession{
        int i;
        Boolean sessionStarted;
        int result;
        Rate lastRate;

        public InnerClassForSession(int i, Boolean sessionStarted, int result, Rate lastRate) {
            this.i = i;
            this.sessionStarted = sessionStarted;
            this.result = result;
            this.lastRate = lastRate;
        }
    }


}
