/*
 * Copyright 2004-2008 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package recom.action;

import javax.annotation.Resource;

import org.seasar.struts.annotation.Execute;

import recom.service.IndexService;


public class IndexAction {

	public long enrollment;
	public long talked;
	public long percentage;
	public long leftOver;
	
	@Resource
	protected IndexService indexService;
	
	
	/**
	 * ダッシュボードに表示するためのデータを取得し格納するメソッド.
	 * @return
	 */
    @Execute(validator = false)
	public String index() {
    	
    	enrollment = indexService.getEnrollment();
    	talked = indexService.getTalked();
    	leftOver = enrollment - talked;
    	percentage =talked*100 / enrollment ;
    	
        return "index.jsp";
	}
    
}
