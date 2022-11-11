import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '工序代码',
    align:"center",
    dataIndex: 'processCode'
   },
   {
    title: '工序名称',
    align:"center",
    dataIndex: 'processName'
   },
   {
    title: '工序描述',
    align:"center",
    dataIndex: 'processDescribe'
   },
   {
    title: '图片',
    align:"center",
    dataIndex: 'image'
   },
   {
    title: '视频',
    align:"center",
    dataIndex: 'vedio'
   },
   {
    title: '做工说明',
    align:"center",
    dataIndex: 'mkExplain'
   },
   {
    title: '品质要求',
    align:"center",
    dataIndex: 'qualityRequire'
   },
   {
    title: '工序时间',
    align:"center",
    dataIndex: 'processTime'
   },
   {
    title: '工序单价',
    align:"center",
    dataIndex: 'price'
   },
   {
    title: '工序等级',
    align:"center",
    dataIndex: 'grade'
   },
   {
    title: '针距',
    align:"center",
    dataIndex: 'needlePitch'
   },
   {
    title: '手工宽放',
    align:"center",
    dataIndex: 'manualWide'
   },
   {
    title: '手工时间',
    align:"center",
    dataIndex: 'manualTime'
   },
   {
    title: '设备转速',
    align:"center",
    dataIndex: 'machineSpeed'
   },
   {
    title: '设备宽放',
    align:"center",
    dataIndex: 'machineWide'
   },
   {
    title: '设备时间',
    align:"center",
    dataIndex: 'machineTime'
   },
   {
    title: '设备浮于',
    align:"center",
    dataIndex: 'machineFloat'
   },
   {
    title: '绑包宽放',
    align:"center",
    dataIndex: 'bundleWide'
   },
   {
    title: '绑包时间',
    align:"center",
    dataIndex: 'bundleTime'
   },
   {
    title: '合计（手工TMU）',
    align:"center",
    dataIndex: 'totalManualTmu'
   },
   {
    title: '合计（设备TMU）',
    align:"center",
    dataIndex: 'totalMachineTmu'
   },
   {
    title: '合计（手工秒）',
    align:"center",
    dataIndex: 'totalMaunal'
   },
   {
    title: '合计（设备秒）',
    align:"center",
    dataIndex: 'totalMachine'
   },
   {
    title: '企业id',
    align:"center",
    dataIndex: 'enterpriseId'
   },
   {
    title: '服装类型id',
    align:"center",
    dataIndex: 'clothsTypeId'
   },
   {
    title: '工段代码',
    align:"center",
    dataIndex: 'worksectionCode'
   },
   {
    title: '工序类型',
    align:"center",
    dataIndex: 'processType'
   },
   {
    title: '创建人',
    align:"center",
    dataIndex: 'createBy'
   },
   {
    title: '创建时间',
    align:"center",
    dataIndex: 'createTime'
   },
   {
    title: '更新人',
    align:"center",
    dataIndex: 'updateBy'
   },
   {
    title: '更新时间',
    align:"center",
    dataIndex: 'updateTime'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '工序代码',
    field: 'processCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入工序代码!'},
          ];
     },
  },
  {
    label: '工序名称',
    field: 'processName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入工序名称!'},
          ];
     },
  },
  {
    label: '工序描述',
    field: 'processDescribe',
    component: 'Input',
  },
  {
    label: '图片',
    field: 'image',
    component: 'Input',
  },
  {
    label: '视频',
    field: 'vedio',
    component: 'Input',
  },
  {
    label: '做工说明',
    field: 'mkExplain',
    component: 'Input',
  },
  {
    label: '品质要求',
    field: 'qualityRequire',
    component: 'Input',
  },
  {
    label: '工序时间',
    field: 'processTime',
    component: 'InputNumber',
  },
  {
    label: '工序单价',
    field: 'price',
    component: 'InputNumber',
  },
  {
    label: '工序等级',
    field: 'grade',
    component: 'InputNumber',
  },
  {
    label: '针距',
    field: 'needlePitch',
    component: 'InputNumber',
  },
  {
    label: '手工宽放',
    field: 'manualWide',
    component: 'InputNumber',
  },
  {
    label: '手工时间',
    field: 'manualTime',
    component: 'InputNumber',
  },
  {
    label: '设备转速',
    field: 'machineSpeed',
    component: 'InputNumber',
  },
  {
    label: '设备宽放',
    field: 'machineWide',
    component: 'InputNumber',
  },
  {
    label: '设备时间',
    field: 'machineTime',
    component: 'InputNumber',
  },
  {
    label: '设备浮于',
    field: 'machineFloat',
    component: 'InputNumber',
  },
  {
    label: '绑包宽放',
    field: 'bundleWide',
    component: 'InputNumber',
  },
  {
    label: '绑包时间',
    field: 'bundleTime',
    component: 'InputNumber',
  },
  {
    label: '合计（手工TMU）',
    field: 'totalManualTmu',
    component: 'InputNumber',
  },
  {
    label: '合计（设备TMU）',
    field: 'totalMachineTmu',
    component: 'InputNumber',
  },
  {
    label: '合计（手工秒）',
    field: 'totalMaunal',
    component: 'InputNumber',
  },
  {
    label: '合计（设备秒）',
    field: 'totalMachine',
    component: 'InputNumber',
  },
  {
    label: '企业id',
    field: 'enterpriseId',
    component: 'Input',
  },
  {
    label: '服装类型id',
    field: 'clothsTypeId',
    component: 'Input',
  },
  {
    label: '工段代码',
    field: 'worksectionCode',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入工段代码!'},
          ];
     },
  },
  {
    label: '工序类型',
    field: 'processType',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入工序类型!'},
          ];
     },
  },
  {
    label: '创建人',
    field: 'createBy',
    component: 'Input',
  },
  {
    label: '创建时间',
    field: 'createTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '更新人',
    field: 'updateBy',
    component: 'Input',
  },
  {
    label: '更新时间',
    field: 'updateTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
	// TODO 主键隐藏字段，目前写死为ID
	{
	  label: '',
	  field: 'id',
	  component: 'Input',
	  show: false
	},
];



/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}