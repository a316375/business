package xyxgame.business;

import com.mob.imsdk.IChatManager;
import com.mob.imsdk.MobIMCallback;
import com.mob.imsdk.model.IMConversation;
import com.mob.imsdk.model.IMMessage;
import com.mob.imsdk.model.IMReminder;

import java.util.List;

public class UseMessage  extends  IMMessage implements IChatManager {


    @Override
    public IMMessage createTextMessage(String s, String s1, int i) {
        IMMessage imMessage=new IMMessage();
        imMessage.setType(i);
        imMessage.setTo(s);
        imMessage.setBody(s1);
        return imMessage;
    }

    @Override
    public IMMessage createImageMessage(String s, String s1, int i) {
        return null;
    }

    @Override
    public IMMessage createAudioMessage(String s, String s1, int i, int i1) {
        return null;
    }

    @Override
    public IMMessage createVideoMessage(String s, String s1, int i) {
        return null;
    }

    @Override
    public IMMessage createFileMessage(String s, String s1, int i) {
        return null;
    }

    @Override
    public void sendMessage(IMMessage imMessage, MobIMCallback<Void> mobIMCallback) {

    }

    @Override
    public void getAllLocalConversations(MobIMCallback<List<IMConversation>> mobIMCallback) {

    }

    @Override
    public void setConversationDisturb(String s, int i, boolean b, MobIMCallback<Boolean> mobIMCallback) {

    }

    @Override
    public void getConversationDisturb(String s, int i, MobIMCallback<Boolean> mobIMCallback) {

    }

    @Override
    public void getMessageList(String s, int i, int i1, int i2, MobIMCallback<List<IMMessage>> mobIMCallback) {

    }

    @Override
    public void getMessageList(String s, int i, int i1, long l, MobIMCallback<List<IMMessage>> mobIMCallback) {

    }

    @Override
    public boolean delMessage(String s) {
        return false;
    }

    @Override
    public boolean clearConversationMessage(String s, int i) {
        return false;
    }

    @Override
    public boolean delConversation(String s, int i) {
        return false;
    }

    @Override
    public int getAllUnreadMessageCount(boolean b) {
        return 0;
    }

    @Override
    public int getConversationUnreadMessageCount(String s, int i) {
        return 0;
    }

    @Override
    public boolean markAllMessageAsRead() {
        return false;
    }

    @Override
    public boolean markConversationAllMessageAsRead(String s, int i) {
        return false;
    }

    @Override
    public boolean markMessageAsRead(String s) {
        return false;
    }

    @Override
    public void getReminderList(MobIMCallback<List<IMReminder>> mobIMCallback) {

    }

    @Override
    public void updateIMMessageLocalPath(String s, String s1, MobIMCallback<Boolean> mobIMCallback) {

    }

    @Override
    public void markAudioAsPlayed(String s) {

    }
}
