package org.trafficmadness.www.database;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.inject.Singleton;

import org.trafficmadness.www.user.entities.PlayerInfo;

@Singleton
public class Database 
{
	private Map<Long, PlayerInfo> playerInfos = Collections.synchronizedMap(new HashMap<Long, PlayerInfo>());
	private long lastId;
	
	private synchronized long getAndIncrementNextId() {
		return ++lastId;
	}
	
	public List<PlayerInfo> getData()
	{
		return new LinkedList<PlayerInfo>(playerInfos.values());
	}
	
	public PlayerInfo getDataByEmail(String email)
	{
		for(PlayerInfo playerInfo : playerInfos.values())
		{
			if(email.equals(playerInfo.getEmail()))
			{
				return playerInfo;
			}
		}
		
		return new PlayerInfo();
	}
	
	public void addData(PlayerInfo playerInfo)
	{
		if(playerInfo == null)
		{
			return;
		}
		
		playerInfos.put(getAndIncrementNextId(), playerInfo);
	}
	
	public void updateData(PlayerInfo newPlayerInfo)
	{
		if(newPlayerInfo == null)
		{
			return;
		}
		
		PlayerInfo playerInfo = getDataByEmail(newPlayerInfo.getEmail());
		playerInfo.setItems(newPlayerInfo.getItems());
		playerInfo.setScore(newPlayerInfo.getScore());
	}
}
