package io.wms.core.warehouse.dataload;

import java.util.List;

public interface ImportJson<T> {
     List<T> importData();
}
