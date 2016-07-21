/*
 * File name: ConnectManagerImpl
 * Author: Dorsey Q F TANG
 * Date: 7/16/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.service;

import com.cloudata.connector.ConConstants;
import com.cloudata.connector.ReqConnector;
import com.cloudata.connector.callback.impl.CollectionResultCallback;
import com.cloudata.connector.callback.impl.DefaultResultCallback;
import com.cloudata.connector.callback.impl.ResultStrippedCallback;
import com.cloudata.connector.exception.CommandExecutionException;
import com.cloudata.connector.filter.impl.DefaultResultFilter;
import com.cloudata.connector.request.*;
import com.cloudata.connector.response.*;

import java.util.*;

/**
 * An implementation of {@link ConnectManager}.
 *
 * Author: DORSEy
 */
public class ConnectManagerImpl implements ConnectManager {

    /**
     * An instance of {@link ReqConnector}.
     */
    private ReqConnector connector;

    @Override
    public GetSessionKeyResponse getSessionKey(final GetSessionKeyReqParams reqParams) throws CommandExecutionException {
        return connector.connect(reqParams, new DefaultResultCallback<>(GetSessionKeyResponse.class), new DefaultResultFilter());
    }

    @Override
    public boolean releaseSessionKey(final ReleaseSessionKeyReqParams reqParams) throws CommandExecutionException {
        BooleanResultResponse response = connector.connect(reqParams, new DefaultResultCallback<>(BooleanResultResponse.class), new DefaultResultFilter());

        return ConConstants.OK_RESPONSE.equalsIgnoreCase(response.getResult());
    }

    @Override
    public AddSurveyResponse addSurvey(final AddSurveyReqParams reqParams) throws CommandExecutionException {
        return connector.connect(reqParams, new DefaultResultCallback<>(AddSurveyResponse.class), new DefaultResultFilter());
    }

    @Override
    public boolean deleteSurvey(final DeleteSurveyReqParams reqParams) throws CommandExecutionException {
        BooleanStatusResponse response = connector.connect(reqParams, new ResultStrippedCallback<>(new DefaultResultCallback<>(BooleanStatusResponse.class)), new DefaultResultFilter());

        return ConConstants.OK_RESPONSE.equalsIgnoreCase(response.getStatus());
    }

    @Override
    public GetOrSetPropertiesResponse getSurveyProperties(GetSurveyPropertiesReqParams reqParams) throws CommandExecutionException {
        return connector.connect(reqParams, new DefaultResultCallback<>(GetOrSetPropertiesResponse.class), new DefaultResultFilter());
    }

    @Override
    public boolean setSurveyProperties(final SetSurveyPropertiesReqParams reqParams) throws CommandExecutionException {
        GetOrSetPropertiesResponse response = connector.connect(reqParams, new DefaultResultCallback<>(GetOrSetPropertiesResponse.class), new DefaultResultFilter());
        Map<String, Object> props = response.getProps();
        boolean succeed = true;
        Iterator<Object> vals = props.values().iterator();
        while (vals.hasNext()) {
            Boolean val = (Boolean) vals.next();
            succeed = succeed && val.booleanValue();
            if (!succeed)
                break;
        }


        return succeed;
    }

    @Override
    public boolean activateSurvey(final ActivateSurveyReqParams reqParams) throws CommandExecutionException {
        BooleanStatusResponse response = connector.connect(reqParams, new ResultStrippedCallback<>(new DefaultResultCallback<>(BooleanStatusResponse.class)), new DefaultResultFilter());

        return ConConstants.OK_RESPONSE.equalsIgnoreCase(response.getStatus());
    }

    @Override
    public AddGroupResponse addGroup(AddGroupReqParams reqParams) throws CommandExecutionException {
        return connector.connect(reqParams, new DefaultResultCallback<>(AddGroupResponse.class), new DefaultResultFilter());
    }

    @Override
    public boolean deleteGroup(DeleteGroupReqParams reqParams) throws CommandExecutionException {
        DeleteGroupResponse response = connector.connect(reqParams, new DefaultResultCallback<>(DeleteGroupResponse.class), new DefaultResultFilter());

        return (reqParams.getGroupId() == response.getGroupIdRemoved());
    }

    @Override
    public GetOrSetPropertiesResponse getGroupProperties(GetGroupPropertiesReqParams reqParams) throws CommandExecutionException {
        return connector.connect(reqParams, new DefaultResultCallback<>(GetOrSetPropertiesResponse.class), new DefaultResultFilter());
    }

    @Override
    public GetOrSetPropertiesResponse setGroupProperties(SetGroupPropertiesReqParams reqParams) throws CommandExecutionException {
        return connector.connect(reqParams, new DefaultResultCallback<>(GetOrSetPropertiesResponse.class), new DefaultResultFilter());
    }

    @Override
    public boolean deleteQuestion(DeleteQuestionReqParams reqParams) throws CommandExecutionException {
        DeleteQuestionResponse response = connector.connect(reqParams, new DefaultResultCallback<>(DeleteQuestionResponse.class), new DefaultResultFilter());

        return (reqParams.getQuestionId() == response.getQuestionId());
    }

    @Override
    public ImportQuestionResponse importQuestion(ImportQuestionReqParams reqParams) throws CommandExecutionException {
        return connector.connect(reqParams, new DefaultResultCallback<>(ImportQuestionResponse.class), new DefaultResultFilter());
    }

    @Override
    public List<ListSurveysResponse> listSurveys(ListSurveysReqParams reqParams) throws CommandExecutionException {
       ResponseDecorator<ListSurveysResponse> decorator = connector.connect(reqParams, new CollectionResultCallback<>(ListSurveysResponse.class), new DefaultResultFilter());

        return decorator.getRetResponse();
    }

    @Override
    public List<ListGroupsResponse> listGroups(ListGroupsReqParams reqParams) throws CommandExecutionException {
        ResponseDecorator<ListGroupsResponse> decorator = connector.connect(reqParams, new CollectionResultCallback<>(ListGroupsResponse.class), new DefaultResultFilter());

        return decorator.getRetResponse();
    }

    public void setConnector(final ReqConnector connector) {
        this.connector = connector;
    }
}
