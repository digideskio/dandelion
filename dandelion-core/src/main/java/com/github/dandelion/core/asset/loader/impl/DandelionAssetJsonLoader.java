package com.github.dandelion.core.asset.loader.impl;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.dandelion.core.asset.AssetComponent;
import com.github.dandelion.core.config.Configuration;

/**
 * <p>
 * Main asset loader used by Dandelion.
 * 
 * <p>
 * This loader focuses on JSON files inside the {@code dandelion} path and all
 * subpaths.
 */
public class DandelionAssetJsonLoader extends AbstractAssetJsonLoader {
   
	// Logger
    private static final Logger LOG = LoggerFactory.getLogger(DandelionAssetJsonLoader.class);

    @Override
    protected Logger getLogger() {
        return LOG;
    }

    @Override
    public String getPath() {
        return "dandelion";
    }

    @Override
    public List<AssetComponent> loadAssets() {
        if("false".equalsIgnoreCase(Configuration.getProperty("dandelion.asset.json.loader.active"))) {
            return Collections.emptyList();
        }
        return super.loadAssets();
    }

	@Override
	public boolean isRecursive() {
		return true;
	}
}