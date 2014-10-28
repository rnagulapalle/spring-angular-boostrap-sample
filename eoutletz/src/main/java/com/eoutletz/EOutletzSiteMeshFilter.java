package com.eoutletz;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.sitemesh.content.tagrules.html.Sm2TagRuleBundle;

public class EOutletzSiteMeshFilter  extends ConfigurableSiteMeshFilter 
{
    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) 
    {
        builder.addTagRuleBundle(new Sm2TagRuleBundle());
    }

}