package org.example.jeffcunningham.fooseballleaderboard.repository.api;

import org.example.jeffcunningham.fooseballleaderboard.bo.Match;
import org.example.jeffcunningham.fooseballleaderboard.bo.Player;
import org.example.jeffcunningham.fooseballleaderboard.bo.matchresult.MatchResult;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import static org.example.jeffcunningham.fooseballleaderboard.repository.api.APIConfiguration.API_HOST;
import static org.example.jeffcunningham.fooseballleaderboard.repository.api.APIConfiguration.MATCH_ENDPOINT;
import static org.example.jeffcunningham.fooseballleaderboard.repository.api.APIConfiguration.RANKING_ENDPOINT;

public interface RankingsAPI {

    @GET(API_HOST + RANKING_ENDPOINT)
    Single<List<Player>> getRankings();

    @POST(API_HOST + MATCH_ENDPOINT)
    Single<MatchResult> saveMatch(@Body Match match);
}
